package algorithm.week02;

import java.util.ArrayDeque;
import java.util.Queue;

public class MakeSameSumTwoQueue {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();

        long q1Sum = 0;
        long q2Sum = 0;
        int end = queue1.length * 3;
        int count = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.offer((long) queue1[i]);
            q1Sum += queue1[i];
            q2.offer((long) queue2[i]);
            q2Sum += queue2[i];
        }

        while (count < end) {
            if (q1Sum == q2Sum) {
                return count;
            } else if (q1Sum > q2Sum) {
                long pop = q1.poll();
                q2.offer(pop);
                q1Sum -= pop;
                q2Sum += pop;
                count++;
            } else {
                long pop = q2.poll();
                q1.offer(pop);
                q2Sum -= pop;
                q1Sum += pop;
                count++;
            }
        }

        return -1;
    }
}
