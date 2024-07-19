package algorithm.week04;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] numbers, int target, int idx, int currentSum) {
        if (idx == numbers.length) {
            if (currentSum == target) return 1;
            else return 0;
        }

        int count = 0;

        count += dfs(numbers, target, idx + 1, currentSum + numbers[idx]);

        count += dfs(numbers, target, idx + 1, currentSum - numbers[idx]);

        return count;
    }
}
