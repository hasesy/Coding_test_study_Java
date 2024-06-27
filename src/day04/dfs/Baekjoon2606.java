package day04.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        int count = -1;

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            int top = stack.pop();

            if (!visited[top]) {
                visited[top] = true;
                count++;

                for (int i = N; i >=1; i--) {
                    if (graph[top][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }

        System.out.println(count);
    }
}
