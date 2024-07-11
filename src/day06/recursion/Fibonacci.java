package day06.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int number = 10;
        int result = fibonacci(number);
        System.out.println("Fibonacci number at position " + number + " is " + result);
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
