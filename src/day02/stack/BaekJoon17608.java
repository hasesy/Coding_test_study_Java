package day02.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < inputCount; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int maxNum = stack.pop();
        int result = 1;

        while (!stack.isEmpty()) {
            int a = stack.pop();

            if (maxNum < a) {
                maxNum = a;
                result += 1;
            }
        }

        System.out.println(result);
    }
}
