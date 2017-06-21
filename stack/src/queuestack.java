/**
 * Created by apple on 18/04/2017.
 */
import java.util.*;


class queuestack {

        private Stack<Integer> in;
        private Stack<Integer> out;
        public queuestack() {
            // Write your solution here.
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        public Integer poll() {
            move();
            return out.isEmpty() ? null : out.pop();
        }

        private void move() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
        public void offer(int element) {
            in.push(element);
        }

        public Integer peek() {
            move();
            return out.isEmpty() ? null : out.peek();
        }

        public int size() {
            move();
            return out.size();
        }

        public boolean isEmpty() {
            move();
            return out.isEmpty();
        }
    }


