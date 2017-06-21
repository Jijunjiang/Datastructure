package StringII;

/**
 * Created by apple on 19/06/2017.
 */
import java.util.*;
public class solution {
    public String rightShift(String input, int n) {
        if (input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();
        n %= array.length;
        reverse(array, 0, array.length - n - 1);
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - 1);

        return new String(array);
    }

    public String reverseWords(String input) {
        // Write your solution here.
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        int i = 0;
        int j;
        for (j = 0; j < array.length; j++) {
            if (array[j] == ' ' || j == array.length) {
                reverse(array, i, j - 1);
                i = j + 1;
            }
        }
        reverse(array, i, j - 1);
        return new String(array);
    }



    private void reverse(char[] array, int left, int right) {
        if (right - left + 1 > array.length) {
            return;
        }

        if (right - left == 0) {
            return;
        }

        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    ///////////////////////////////////////////////////////////////////////
    //with duplicate
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(0, result, array);
        return  result;
    }

    private void helper(int index, List<String> result, char[] array) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }

        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap(array, index, i);
                helper(index + 1, result, array);
                swap(array,index, i);
            }
        }

    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
////////////////////////////////////////////////////////////////////////////////////

    public String replaceI(String input, String s, String t) {
        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(array, s, t);
        }
        return replaceLonger(array, s, t);
    }

    private String replaceShorter(char[] input, String s, String t) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (fast < input.length - s.length() && equalSubstring(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }

    private String replaceLonger(char[] input, String s, String t) {
        ArrayList<Integer> matches = getAllMatches(input, s);
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
        int lastIndex = matches.size() - 1;
        int slow = input.length - 1;
        int fast = result.length - 1;
        while (slow >= 0) {
            if (lastIndex >= 0 && slow == matches.get(lastIndex)) {
                copySubstring(result, fast - t.length() + 1, t);
                fast -= t.length();
                slow -= s.length();
                lastIndex--;
            } else {
                result[fast--] = input[slow--];
            }
        }
        return new String(result);
    }

    // check if the substring from fromIndex is the same as s
    private boolean equalSubstring(char[] input, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }

    private ArrayList<Integer> getAllMatches(char[] input, String s) {
        ArrayList<Integer> matches = new ArrayList<Integer>();
        int i = 0;
        while (i <= input.length - s.length()) {
            if (equalSubstring(input, i, s)) {
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }
///////////////////////////////////////////////////////////////////////////////////////
    public String replace(String input, String s, String t) {
    // Write your solution here.
    int j = 0;
    int i = 0;
    StringBuilder sb = new StringBuilder();
    char[] array = input.toCharArray();
    while (j < input.length() - s.length() + 1) {
        if (s.charAt(0) == array[j] && isEqual(array, s, j)) {
            sb.append(t);
            j += s.length();
        } else {
            sb.append(array[j++]);
        }
    }
    if (j < input.length()) {
        for (i = j; i < input.length(); i++) {
            sb.append(array[i]);
        }
    }
    return sb.toString();
}

    private boolean isEqual(char[] array, String s, int index) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != array[index+i]) {
                return false;
            }
        }
        return true;
    }

///////////////////////////////////////////////////////////////////////////////////////
    /*
    a b c | d e f 1 2 3 4 5 6

    a b c | f e d 3 2 1 | 4 5 6
    a b c 1 2 3 d e f 4 5 6
    /                          \
    a bc 1 23	def456
    a cb 1 23
    a 1 bc 23           d4ef56
    /         \
    a1	bc23
        b2c3

    ab cde 12 345
    ab edc 21 345
    ab 12 cde 345
    /                  \
    ab12           cde345

     */

    public int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

}
