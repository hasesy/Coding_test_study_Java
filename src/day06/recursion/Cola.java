package day06.recursion;

public class Cola {
    public int solution(int a, int b, int n) {
        return recursion(a, b, n, 0);
    }

    private static int recursion(int a, int b, int n, int totalBottles) {
        if (a > n) return totalBottles;
        int newCola = (n / a) * b;
        int remainingBottles = (n % a) + newCola;
        return recursion(a, b, remainingBottles, totalBottles + newCola);
    }
}
