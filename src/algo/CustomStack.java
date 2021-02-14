package algo;

import java.util.Deque;
import java.util.LinkedList;

class CustomStack {

    Deque<Integer> stack;
    int maxSize;

    public CustomStack(int maxSize) {
        this.stack = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (stack.size() == maxSize) {
            return;
        }

        if (stack.size() < maxSize) {
            stack.push(x);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pop();
    }

    public void increment(int k, int val) {
        Deque<Integer> tmpStack = new LinkedList<>();
        while (stack.size() > k) {
            tmpStack.offer(stack.pop());
        }
        while (k > 0 && !stack.isEmpty()) {
            int pop = stack.pop();
            pop += val;
            tmpStack.offer(pop);
        }
        while (!tmpStack.isEmpty()) {
            stack.offer(tmpStack.pop());
        }
    }
}