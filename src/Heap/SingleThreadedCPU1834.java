package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU1834 {
    private record Task(int enqueueTime, int processingTime, int index) implements Comparable<Task> {

        @Override
        public int compareTo(Task other) {
            if (this.processingTime != other.processingTime) {
                return Integer.compare(this.processingTime, other.processingTime);
            }
            return Integer.compare(this.index, other.index);
        }
    }

    public int[] getOrder(int[][] tasks) {
        int count = tasks.length;
        Task[] sortedTasks = new Task[count];

        for (int i = 0; i < count; i++) {
            sortedTasks[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(sortedTasks, Comparator.comparingInt(t -> t.enqueueTime));

        PriorityQueue<Task> pq = new PriorityQueue<>();

        int[] result = new int[count];
        long currentTime = 0;
        int taskIndex = 0, resultIndex = 0;

        while (resultIndex < count) {
            while (taskIndex < count && sortedTasks[taskIndex].enqueueTime <= currentTime) {
                pq.offer(sortedTasks[taskIndex]);
                taskIndex++;
            }

            if (pq.isEmpty()) {
                currentTime = sortedTasks[taskIndex].enqueueTime;
                continue;
            }

            Task current = pq.poll();
            currentTime += current.processingTime;
            result[resultIndex++] = current.index;
        }

        return result;
    }
}

