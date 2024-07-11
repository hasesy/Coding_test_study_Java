package day06.recursion;

public class Factorial {
    public static void main(String[] args) {
        int number = 8;
        int result = factorial(number);
        System.out.println(" = Factorial result : " + result);
    }

    private static int factorial(int n) {
        if (n <= 1) {
            System.out.print(n);
            return n;
        }
        System.out.print(n + " * ");
        return factorial(n - 1) * n;
    }
}
