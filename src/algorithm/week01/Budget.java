package algorithm.week01;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int answer = 0;
        int amount = 0;

        for (int i = 0; i < d.length; i++) {
            amount += d[i];

            if (amount > budget) {
                return answer;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
