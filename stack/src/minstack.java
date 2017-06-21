/**
 * Created by apple on 20/04/2017.
 */

import java.util.*;

public class minstack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public minstack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int value) {
        stack.offerFirst(value);

        if(minStack.isEmpty() || value <= minStack.peekFirst()) {
            minStack.offerFirst(value);
        }

    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        int result = stack.pollFirst();
        if (result <= minStack.peekFirst()) {
            minStack.pollFirst();
        }
        return result;
    }

    public Integer top() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peekFirst();
    }

    public Integer min() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peekFirst();
    }

}
