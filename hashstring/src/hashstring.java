/**
 * Created by apple on 14/06/2017.
 */
// if the string should be expanded, first calculate the space should be exapnded,
// then from back to front
// implement the hashtable to record the pivot of index
import java.util.*;

public class hashstring {
    static public void main(String[] arg) {

        System.out.print(remove("abcde", "ab"));

    }
    static public String remove(String input, String t) {
        // Write your solution here.
        if (input.length() == 0 || t.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        char[] tarray = t.toCharArray();
        int i = 0;
        int j = 0;
        for (i = 0; i < array.length; i++) {
            if (!inArray(array[i], tarray)) {
                array[j++] = array[i];
            }
        }
        return new String(array, 0, j);
    }

    static private boolean inArray(char input, char[] t) {
        for (char c : t) {
            if (input == c) {
                return true;
            }
        }
        return false;
    }
    ///////////////////////////////////////////////////////////////////////////////////
    static private String removeSpace(String s) {
        char[] input = s.toCharArray();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        if (input[0] != ' ') {
            sb.append(input[0]);
        }
        while (i < input.length) {
            if (input[i] != ' ') {
                sb.append(input[i++]);
            } else {
                    sb.append(' ');
                while (i < input.length && input[i] == ' ') {
                    i++;
                }
            }
        }
        if (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ' ' ) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

    }
    ////////////////////////////////////////////////////////////////////////////////////////
    static public int strstr(String large, String small) {
        if (small.length() == 0) {
            return 0;
        }
        if (small.length() > large.length()) {
            return -1;
        }
        char[] lArray = large.toCharArray();
        char[] sArray = small.toCharArray();
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (lArray[i] == sArray[0]) {
                int j = 0;
                for (j = 0; j < small.length(); j++) {
                    if (lArray[j+i] != sArray[j]) {
                        break;
                    }

                }
                System.out.print("here:");
                System.out.print(j);
                if (j == small.length() ) {
                    return i;
                }

            }
        }

        return -1;
    }
///////////////////////////////////////////////////////////////////////////////////////////////

    static public String deDupSol(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 1; i < array.length; i++) {
            if (end == -1 || array[i] != array[end]) {
                array[++end] = array[i];
            } else {
                end--;
                while (i + 1 < array.length && array[i] == array[i + 1]) {
                    i++;
                }
            }
        }
        return new String(array, 0, end + 1);
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static public String deDup(String input) {
        // Write your solution here.
        if (input.length() == 0) {
            return input;
        }
        char[] charArray = input.toCharArray();
        Deque<Character> stack = new LinkedList();
        int i = 0;
        int j = 0;

        while(i < charArray.length) {
            if (stack.size() == 0 || stack.peekFirst() != charArray[i]) {
                stack.offerFirst(charArray[i++]);
            } else {
                int justPoll = stack.pollFirst();

                while (i < charArray.length && justPoll == charArray[i]) {
                    i++;
                }

            }

        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String[] topKFrequent(String[] combo, int k) {
        if (combo.length == 0) {
            return new String[0];
        }

        Map<String, Integer> freqMap = getFreqMap(combo);

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
            new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    if (e1.getValue().equals(e2.getValue())) {
                        return 0;
                    }
                    return e1.getValue() < e2.getValue() ? -1 : 1;
                }
            }
        );

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s: combo) {
            Integer freq = freqMap.get(s);
            if (freq == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, freq + 1);
            }
        }
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
