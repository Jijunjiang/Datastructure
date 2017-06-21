/**
 * Created by apple on 20/04/2017.
 */
public class Recursion {

    public static void main(String[] arg) {
        System.out.println("start:");
        permutation("abc");
    }

    public static void permutation(String str, int index) {
        if (str.length() == 0) {
            System.out.print("-----");
            return;
        }
        char[] arr = str.toCharArray();
        for (int i = index; i < str.length(); i++) {
            char temp = arr[i];
            System.out.print(temp);
            arr[i] = '\0';
            String b = new String(arr);
            permutation(b);
            arr[i] = temp;
        }
    }

}
