package day05.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LabyrinthSearch {
    public static int N, M;
    public static boolean[][] visited;
    public static int[][] graph;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startX = 1, startY = 1;
        visited = new boolean[N + 1][M + 1];
        graph = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine(); // 첫 줄 받아온 걸 line 에 넣은 것
            for (int j = 1; j <= M; j++) {
                if (line.charAt(j - 1) == '1') {
                    graph[i][j] = 1;
                }
            }
        }

        bfs(startX, startY);
        System.out.println(graph[N][M]);
    }

    private static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startY][startX] = true;
        graph[startY][startX] = 1;

        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            int x = nowPoint.x;
            int y = nowPoint.y;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 1 && nextX <= M && nextY >= 1 && nextY <= N && graph[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    queue.offer(new Point(nextX, nextY));
                    visited[nextY][nextX] = true;
                    graph[nextY][nextX] = graph[nowPoint.y][nowPoint.x] + 1;
                }
            }
        }
    }
}
