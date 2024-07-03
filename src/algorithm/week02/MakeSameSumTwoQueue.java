package algorithm.week02;

import java.util.LinkedList;
import java.util.Queue;

public class MakeSameSumTwoQueue {
    public int solution(int[] queue1, int[] queue2) {
        long average = average(queue1, queue2);

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.offer((long) queue1[i]);
            q2.offer((long) queue2[i]);
        }

        int count = 0;
        while (true) {
            long sum = 0;
            for (int i = 0; i < q1.size(); i++) {
                sum += q1.peek();
            }

            if (sum > average) {
                long pop = q1.poll();
                q2.offer(pop);
                count++;
            } else if (sum < average) {
                long pop = q2.poll();
                q1.offer(pop);
                count++;
            } else {
                long sum2 = 0;
                for (int i = 0; i < q2.size(); i++) {
                    sum2 += q2.peek();
                }
                if (sum2 == average) break;
            }
        }

        return count;
    }

    private long average(int[] queue1, int[] queue2) {
        long total = 0;

        for (int i = 0; i < queue1.length; i++) {
            total += queue1[i];
            total += queue2[i];
        }

        return total / 2;
    }
}
