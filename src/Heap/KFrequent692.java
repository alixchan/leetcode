package Heap;

import java.util.*;

public class KFrequent692 {
    private final LinkedList<String> result = new LinkedList<>();

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
            (a, b) -> {
                int freqCompare = freq.get(a) - freq.get(b);
                return freqCompare == 0 ? b.compareTo(a) : freqCompare;
            });

        for (String word : freq.keySet()) {
            heap.offer(word);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            result.addFirst(heap.poll());
        }
        return result;
    }

}
