/**
 * Created by apple on 12/06/2017.
 */
import java.util.*;
public class subset {
    static public void main(String[] arg) {
        int[] coins = {25, 10, 5, 2, 1};
        List<List<Integer>> l = combinations(100, coins);
        for (List<Integer> s : l) {
            for (int i : s) {
                System.out.print(i);
                System.out.print(",");
            }
            System.out.println(" ");
        }
    }
    static public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    static private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }

        helper(set, sb, index + 1, result);
        helper(set, sb.append(set[index]), index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }
/////////////////////////////////////////////2ed solution/////////////////////////////////////////


    static public List<String> subSetsII(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helperII(arraySet, sb, 0, result);
        return result;
    }

    static public void helperII(char[] set, StringBuilder sb, int index, List<String> result) {
        result.add(sb.toString());
        for (int i = index; i < set.length; i++) {
            sb.append(set[i]);
            helperII(set, sb, i+1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
/////////////////////////////////all order string////////////////////////////////////////

    static public List<String> allOrder(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        helperIII(arraySet, result, 0);
        StringBuilder sb = new StringBuilder();
        return result;


    }

    static public void helperIII(char[] set, List<String> result, int index) {
        if (index >= set.length - 1) {
            result.add(Arrays.toString(set));
            return;
        }
        for (int i = index; i < set.length; i++) {
            swap(set, index, i);
            helperIII(set, result, index + 1);
            swap(set, index, i);
        }
    }


    static public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////
    static public List<String> validParentheses(int n) {
    // Write your solution here.
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            return result;
        }
        helper(n, 0, 0, result, sb);
        return result;
    }

    static private void helper(int n, int countLeft, int countRight, List<String> result,
                        StringBuilder sb) {
        if (countLeft == n && countRight == n) {
            result.add(sb.toString());
            return;
        }
        if (countLeft < n) {
            sb.append("(");
            helper(n, countLeft + 1, countRight, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (countRight < countLeft) {
            sb.append(")");
            helper(n, countLeft, countRight + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        return;

    }

///////////////////////////////coin combination////////////////////////////////////
    // for different coins, there is a range of number of coins we could apply
    // like for target of 1000, for coin 25, the range is the integer in [0, 40]
    // for coin 30 teh range is the integers in [0, 33]
    // date structure: tree
    static public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> cur = new ArrayList<>();
        if (target == 0) {
            return result;
        }
        help(target, coins, 0, cur, result);
        return result;
    }

    static private void help(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
      if (index == coins.length - 1) {
          if (target % coins[index] == 0) {
              cur.add(target / coins[index]);
              result.add(new ArrayList<Integer>(cur));
              cur.remove(cur.size() - 1);
          }
          return;
      }

      int max = target / coins[index];
      for (int i = 0; i <= max; i++) {
          int target2 = target - i * coins[index];
          cur.add(i);
          help(target2, coins, index + 1, cur, result);
          cur.remove(cur.size() - 1);
      }
    }

}




