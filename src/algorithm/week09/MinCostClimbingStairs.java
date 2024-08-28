package algorithm.week09;

public class MinCostClimbingStairs {
    public int solution(int[] cost) {
        // 목표 계단 수 + 1(cost의 길이 + 1) 크기의 dp 테이블을 만든다.
        int[] dp = new int[cost.length + 1];

        // 0번째, 1번째 계단에 0을 저장한다.
        dp[0] = 0;
        dp[1] = 0;

        // 2번째 계단부터 n번째 계단까지 올라간다.
        for (int i = 2; i <= cost.length; i++) {
            // 점화식에 따라 각 계단에 오르기 위해 필요한 최소 비용을 구한다.
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[cost.length];
    }
}
