package algorithm.week02;

import java.util.LinkedList;
import java.util.Queue;

public class CorrectParentheses {
    boolean solution(String s) {
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            q.offer(c);
        }

        int left = 1;
        int right = 0;
        char start = q.poll();

        if (start == ')') return false;

        while (!q.isEmpty()) {
            char par = q.poll();
            if (par == '(') {
                left++;
            } else {
                right++;
            }

            if (left < right) {
                return false;
            }
        }

        if (left == right) {
            return true;
        } else {
            return false;
        }
    }
}
