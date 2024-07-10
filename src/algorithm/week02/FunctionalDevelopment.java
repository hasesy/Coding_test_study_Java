package algorithm.week02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class FunctionalDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int workDays = 1;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                workDays++;
            }
            q.offer(workDays);
        }

        int count = 1;
        int nowWorkDays = q.poll();

        while (!q.isEmpty()) {
            if (q.peek() <= nowWorkDays) {
                q.poll();
                count++;
            } else {
                list.add(count);
                nowWorkDays = q.poll();
                count = 1;
            }
        }
        // 마지막 값 혼자 일 때 또는 값이 갱신되지 않아서 count만 늘어났을 때
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
