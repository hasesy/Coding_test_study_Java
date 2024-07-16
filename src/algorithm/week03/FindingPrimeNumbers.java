package algorithm.week03;

import java.util.Arrays;
import java.util.HashSet;

public class FindingPrimeNumbers {
    HashSet<Integer> list = new HashSet<>();
    static boolean[] isPrime;
    static int answer;

    public int solution(String numbers) {
        int max = 10_000_000;
        isPrime = isPrime(max);
        boolean[] visited = new boolean[numbers.length()];

        permutation(0, numbers, visited, 0);

        for (int i : list) {
            if (isPrime[i]) answer++;
        }

        return answer;
    }


    private void permutation(int current, String numbers, boolean[] visited, int digit) {
        if (digit == numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                int newNumber = current + (int)((numbers.charAt(i) - '0') * Math.pow(10, digit));
                list.add(newNumber);

                permutation(newNumber, numbers, visited, digit + 1);

                visited[i] = false;
            }
        }

    }

    private boolean[] isPrime(int max) {
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < max; i++) {
                for (int j = i * i; j < max; j += i) {
                    isPrime[j] = false;
                }
        }

        return isPrime;
    }
}
