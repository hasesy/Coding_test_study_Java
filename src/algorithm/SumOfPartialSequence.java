package algorithm;

public class SumOfPartialSequence {
    public int[] solution(int[] sequence, int k) {
        int [] answer = {0, 1000000};
        int start = 0;
        int sum = 0;

        for (int end = 0; end < sequence.length; end++) {
            sum += sequence[end];

            while (sum > k) {
                sum -= sequence[start];
                start++;
            }

            if (sum == k) {
                if ((end - start) < (answer[1] - answer[0])) {
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
        return answer;
    }
}
