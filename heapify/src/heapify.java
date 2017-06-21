/**
 * Created by apple on 22/04/2017.
 *
 * heap:
 * 对于每一个node，堆顶小于下面所有元素，
 * 是个complete tree，高度差不超过1，往左挤
 * index:   leftchild = parent * 2 + 1    rightchild = parent * 2 + 2
 *
 * insert: 先插入到queue最后，每一层check一遍swap一遍， T = (log(n))
 * update: 如果变小了网上check swap，如果变大了往下check然后swap， T = log(n)
 * get/top: T = O(1)
 * pop: 把queue最后一个元素swap到堆顶，swap，T = O(log(n))
 * heapify: O(n)
 *
 * delete: eager delete, 和tail swap。。。。。lazy delete: 先不删到堆顶再删
 *
 * 例题1：unsort array 里面最小的K个
 * 解1：整个 heapify pop K 个: T = O(n + k*log(n)), heapify K 个, 一个个push,: T = O(k + (n - k)*log(n))
 * 解2：用pivot
 *
 *
 *
 *
 * graph:
 * 表示方法：matrix, easy
 *   0 1 2 3
 * 0 0 1 0 1
 * 1 0 0 0 0
 * 2 1 0 0 0
 * 3 0 0 0 2
 *
 * hash: node + vector(nodes linked to node)
 *
 * search approach:
 *
 *
 *
 * BFS-1, breadth first search （当需要考虑同一层内的关系 deal with relations in same level）
 * how to describe a relatively complexity algorithm
 * a. what kind of data structure that this algorithm uses
 *  1. queue
 *      expand(1) a paraent node and generate all successors
 *
 * b. what are the actions of this algorithm step by step
 *      1. initial: insert the starter node into the queue
 *      2. process: while the queue is not empty
 *                         generate all its successors and insert all of them into the
 *
 * 例题1：分层打印node
 * 例题2：Bipartite： 从 u BFS -> 2,3, 从 v BFS -> 1,2, 2矛盾
 * 例题3：determine complete tree: 一旦发现null,之后的node都不能有新的孩子
 *
 * discussion：
 *      1。当需要考虑同一层内的关系 deal with relations in same level）
 *      2。BFS1 is not the right algorithm to find the closest distance between two node with cost
 *
 *
 *
 * Best First Search(BFS-2):
 * datastructure: priority queue(min heap)
 *
 * Dijkstra's algorithm
 *initial: stater node (4,0)
 * 2. pop (4,0), generate successors, (5, 10) (3, 1) (6, 1)      ----- tie 均势  pqueue,弹出cost最小的
 * 3. pop (6,1), generate nothing
 * 4. pop (3,1), generate (2, 1+1(3的cost)) = (2,2)
 *
 * 性质，永远增，只要POP就是最短距离
 *
 *
 */
// 2n - 1, 2n + 1, (n - 1) / 2
import java.util.*;


public class heapify {

    public static void main(String []arg) {
        int[] array = {6,3,6,10,222,-3,3,4,5,7,8,5,4,5,7};
        System.out.println(Arrays.toString(kSmallest(array, 3)));
        kSmallest(array, 3);

    }

    public static int[] kSmallest(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;//理解后加入的比前面的大 o2 > o1 true: maxheap, o2 < o1: minheap
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }

        return result;
    }


    public static void heapify2(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return;
        }
        int[] result = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer> (k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });

        for (int i = 0; i < array.length; i ++) {
            heap.offer(array[i]);
        }


        for (int i = 0; i < array.length; i ++) {

            System.out.print(heap.poll());

        }


    }

    //分层打印node


}
