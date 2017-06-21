/**
 * Created by apple on 08/05/2017.
 */
import java.util.*;
import java.util.stream.StreamSupport;

public class test {
    public static void main(String arg[]) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List re = spiral(m);
        System.out.println(Arrays.toString(re.toArray()));
    }
    static List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List l = new ArrayList<Integer>();
        spiral(matrix, 0, l);
        return l;
    }
    static void spiral(int[][] matrix, int offset, List<Integer> l) {
        if (matrix.length == 0) {
            return;
        }
        if (matrix.length == 1 || matrix.length * matrix.length - l.size() == 1) {
            l.add(matrix[matrix.length / 2][matrix.length / 2]);
            System.out.print(matrix[matrix.length / 2][matrix.length / 2]);
            return;
        }

        if (l.size() == matrix.length * matrix.length) {
            return;
        }
        for (int i = 0; i < matrix.length - 2 * offset - 1; i ++) {
            System.out.print(matrix[offset][i + offset]);
            l.add(matrix[offset][i + offset]);
        }
        for (int i = 0; i < matrix.length - 2 * offset - 1; i ++) {
            l.add(matrix[i + offset][matrix.length - offset - 1]);
            System.out.print(matrix[i + offset][matrix.length - offset - 1]);
        }
        for (int i = matrix.length - 2 * offset - 1; i > 0 ; i --) {
            l.add(matrix[matrix.length - offset - 1][i + offset]);
            System.out.print(matrix[matrix.length - offset - 1][i + offset]);
        }
        for (int i = matrix.length - 2 * offset - 1; i > 0 ; i --) {
            l.add(matrix[i + offset][offset]);
            System.out.print(matrix[i + offset][offset]);
        }
        offset++;
        spiral(matrix, offset, l);
    }
}
