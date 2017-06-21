/**
 * Created by apple on 13/05/2017.
 */
import java.util.*;
class cell {
    public int value;
    public int row;
    public int column;

    public cell(int value, int row, int column) {
        this.column = column;
        this.row = row;
        this.value = value;

    }

}
public class DP {

    public static void main(String []arg) {
        int[] a = {2, 4, 3, 1, 6, 1, 1, 1, 0};
        System.out.println(canJump(a));
        int[][] matrix = {{1, 3, 5, 7},

                {2, 4, 8, 9},

                {3, 5, 11, 15},

                {8, 8, 13, 18}};
        for (int i = 1; i <= 16; i++) {
            System.out.println(kthSmallest(matrix, i));
        }
    }
    public static  boolean canJump(int[] array) {
        // Write your solution here.
        if (array.length == 1) {
            return true;
        }
        boolean[] table = new boolean[array.length];
        table [array.length - 1] = true;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i - 1] == 0) {
                table[i - 1] = false;
            } else {
                if (array[i - 1] + i - 1 >= array.length - 1) {
                    table[i - 1] = true;
                }else{
                    table[i - 1] = table[array[i - 1] + i - 1] == true ? true : false;
                }
            }
        }
        return table[0];
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns =  matrix[0].length;

        PriorityQueue<cell> minHeap = new PriorityQueue<cell>(k, new Comparator<cell>(){
            @Override
            public int compare(cell c1, cell c2) {
                if(c1.value == c2.value) {
                    return 0;
                }
                // 第二个和第一个比，minheap,第二个小于第一个就对了
                return c1.value > c2.value ? 1 : -1;
            }
        });

        boolean[][] visited = new boolean[rows][columns];
        minHeap.add(new cell(matrix[0][0], 0, 0));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            cell cur = minHeap.poll();
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
                minHeap.add(new cell(matrix[cur.row+1][cur.column], cur.row+1, cur.column));
                visited[cur.row+1][cur.column] = true;
            }
            if (cur.column + 1 < columns && !visited[cur.row][cur.column+1]) {
                minHeap.add(new cell(matrix[cur.row][cur.column+1], cur.row, cur.column+1));
                visited[cur.row][cur.column+1] = true;
            }
        }

    return minHeap.peek().value;
    }




    /////////////////////////////////////////////////////////////////////////////////////////////////
    








}
