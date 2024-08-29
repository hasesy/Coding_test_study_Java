package algorithm.week08;

import java.util.Arrays;

public class NetworkDelayTime {
    public int solution(int[][] times, int n, int k) {
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[k] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] time : times) {
                if (d[time[0]] != Integer.MAX_VALUE) {
                    d[time[1]] = Math.min(d[time[1]], d[time[0]] + time[2]);
                }
            }
        }

        int maxD = Arrays.stream(d).skip(1).max().getAsInt();
        return maxD == Integer.MAX_VALUE ? -1 : maxD;
    }
}
