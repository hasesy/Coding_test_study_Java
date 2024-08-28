package algorithm.week09;

import java.util.Arrays;

public class CoinChange {
    final int LIMIT = 10001;

    public int solution(int[] coins, int amount) {
        // amount + 1의 크기의 dp를 만들고, 10001로 초기화
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, LIMIT);

        // dp의 0번째 값을 0으로 초기화
        dp[0] = 0;

        // 0부터 amount까지 순회
        for (int i = 0; i < amount; i++) {
            if (dp[i] != LIMIT) {
                for (int coin : coins) {
                    if (i + coin <= amount && dp[i + coin] > dp[i] + 1) {
                        dp[i + coin] = dp[i] + 1;
                    }
                }
            }
        }
        return (dp[amount] == LIMIT) ? -1 : dp[amount];
    }
}
