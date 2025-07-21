package Heap;

import java.util.PriorityQueue;

public class KthLargest703 {
    private final PriorityQueue<Integer> pq;
    private final int capacity;

    public KthLargest703(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        capacity = k;

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);

        if (pq.size() > capacity) {
            pq.poll();
        }

        return pq.peek();
    }
}