package algo;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> bot;
    PriorityQueue<Integer> top;

    /** initialize your data structure here. */
    public MedianFinder() {
        bot = new PriorityQueue<>(Collections.reverseOrder());
        top = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (bot.isEmpty() && top.isEmpty()) {
            bot.offer(num);
        } else if (bot.size() == top.size()) {
            if (num <= bot.peek()) {
                bot.offer(num);
            } else {
                top.offer(num);
            }
        } else if (bot.size() > top.size()) {
            if (num >= bot.peek()) {
                top.offer(num);
            } else {
                top.offer(bot.poll());
                bot.offer(num);
            }
        } else {
            if (num <= top.peek()) {
                bot.offer(num);
            } else {
                bot.offer(top.poll());
                top.offer(num);
            }
        }
    }

    public double findMedian() {
        if (top.size() == bot.size()) {
            if (top.size() == 0) {
                return 0;
            }
            return (double) (top.peek() + bot.peek()) / 2;
        } else if (top.size() > bot.size()) {
            return top.peek();
        } else {
            return bot.peek();
        }
    }
}
