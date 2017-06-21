/**
 * Created by apple on 12/06/2017.
 */
import java.util.*;
public class quicksort {

        static public void main(String[] args){
            int[] array = {1,9,8,5,3,7,4,3,6,3,35};
            int[] newarray = quickSort(array);
            System.out.println(Arrays.toString(newarray));
        }
        static public int[] quickSort(int[] array) {
            if (array.length == 0 || array.length == 1) {
                return array;
            }
            int left = 0;
            int right = array.length - 1;
            quickSort(array, left, right);
            return array;
        }

        static public void quickSort(int[] array, int left, int right) {
            if (left >= right) {
                return;
            }
            int pivot = generatePivot(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);

        }

        static public int generatePivot(int[] array, int left, int right) {
            int l = left;
            int r = right - 1;
            int pivotIndex = l + (int)(Math.random() * (r - l + 1));
            int pivotValue = array[pivotIndex];
            swap(array, right, pivotIndex);
            while(l <= r) {
                if (array[l] < pivotValue) {
                    l++;
                } else if (array[r] > pivotValue) {
                    r--;
                } else {
                    swap (array, l++, r--);
                }
            }
            swap(array, l, right);
            return l;
        }

        static public void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

}
