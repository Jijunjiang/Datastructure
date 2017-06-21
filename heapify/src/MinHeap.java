import java.util.NoSuchElementException;

/**
 * Created by apple on 11/06/2017.
 */
public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length ==0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        this.size = array.length;
        heapify();
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateUp(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index shoud >= 0");
        }
        while(index >= 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    private void percolateDown(int index) {
        if (index > size /2 - 1 || index < 0) {
            throw new IllegalArgumentException("percolate down elements must have child");
        }
        while(index <= (size - 2) / 2) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int swapCandidateIndex = leftChildIndex;
            if (rightChildIndex < size && array[rightChildIndex] < array[leftChildIndex]) {
                swapCandidateIndex = rightChildIndex;
            }
            if (array[index] > array[swapCandidateIndex]) {
                swap(index, swapCandidateIndex);
            } else {
                break;
            }
            index = swapCandidateIndex;
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public MinHeap(int cap) {
        if (cap < 0) {
            throw new IllegalArgumentException("capacity can not less than zero");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[size - 1];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public void offer(int ele){
        if (size == array.length) {
            int[] newArray = new int[array.length  + array.length / 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = ele;
        size++;
        percolateUp(size - 1);
    }

    public int update(int index, int value) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("invalid range");
        }
        int result = array[index];
        array[index] = value;
        if (result > value) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return result;
    }

}
