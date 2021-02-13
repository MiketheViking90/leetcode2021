package algo;

import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (this.pq.size() < this.k) {
            pq.add(val);
        } else {
            if (val > this.pq.peek()) {
                this.pq.poll();
                this.pq.offer(val);
            }
        }

        return this.pq.peek();
    }
}