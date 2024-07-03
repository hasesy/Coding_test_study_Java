package algorithm.week01;

import java.util.Arrays;

public class MakePrime {
    public int solution(int[] nums) {
        int count = 0;
        int maxSum = 2997; // 최대 합은 1000 + 999 + 998 = 2997
        boolean[] isPrime = sieveOfEratosthenes(maxSum);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (isPrime[sum]) count++; // 2997까지의 boolean값이 들어있으니 sum 번째꺼는 sum의 소수여부가 있는 거
                }
            }
        }

        return count;



//        int answer = 0;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    int sum = nums[i] + nums[j] + nums[k];
//                    if (isPrime(sum)) {
//                        answer++;
//                    }
//                }
//            }
//        }
//
//        return answer;
    }

    // 에라토스 테네스의 체
    private boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

//    private boolean isPrime(int num) {
//        for (int i = 2; i <= num / 2; i++) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }
}
