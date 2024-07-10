package algorithm.week02;

import java.util.Stack;

public class StockPrice {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        // 스택에 순서를 넣어주기
        for (int i = 0; i < prices.length; i++) {
            // 스택이 비어있지 않고, 새로 뽑은 값이 스택 최상단 값보다 작을 때
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        return answer;
    }
}
