package algorithm.week06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivideTheEletricalGridInTwo {
    int answer;
    public int solution(int n, int[][] wires) {
        answer = n;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] w : wires) {
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }

        boolean[] visited = new boolean[n + 1];

        dfs(graph, n, 1, visited);

        return answer;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int n, int cur, boolean[] visited) {
        int count = 1;
        visited[cur] = true;

        for (int w : graph.get(cur)) {
            if (!visited[w]) {
                count += dfs(graph, n, w, visited);
            }
        }

        answer = Math.min(answer, Math.abs(n - count * 2));

        return count;
    }
}
