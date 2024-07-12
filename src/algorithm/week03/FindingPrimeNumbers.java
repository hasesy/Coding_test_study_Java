package algorithm.week03;

import java.util.Arrays;
import java.util.List;

public class FindingPrimeNumbers {
    static int answer = 0;
    static boolean[] isPrime;

    public int solution(String numbers) {
        int max = 10000000;
        isPrime = isPrime(max);
        boolean[] visited = new boolean[numbers.length()];
        int[] pieces = new int[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            pieces[i] = Integer.parseInt(numbers.substring(i, i + 1));
        }

        return answer;
    }


    private void recursion(int n, int[] pieces, boolean[] visited) {
        StringBuilder sb = new StringBuilder();

        if (sb.length() == n) {
            boolean result = isPrime[Integer.parseInt(sb.toString())];
        }
        for (int i = 0; i < pieces.length; i++) {
            if (n == 1) {
                boolean result = isPrime[pieces[i]];
                if (result) answer++;
            } else {
            }
        }
    }

    private boolean[] isPrime(int max) {
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
