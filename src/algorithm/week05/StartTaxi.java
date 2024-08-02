package algorithm.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartTaxi {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int N, M;
    static int[][] map, destination;
    static Taxi taxi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        destination = new int[M+1][2]; // 각 사람들의 목적지 행과 열 저장

        // 맵 형성, 벽이 1
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 택시 시작 좌표
        st = new StringTokenizer(br.readLine());
        taxi = new Taxi(fuel, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        // 손님 좌표와 목적지 좌표
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            // 손님 좌표 구분 위해 -i로 표시
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -i;

            // 목적지 좌표
            destination[i][0] = Integer.parseInt(st.nextToken());
            destination[i][1] = Integer.parseInt(st.nextToken());
        }

    }

    // 현재 연료에서 손님 찾을 수 있으면 true
    static boolean findPerson() {
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{taxi.x, taxi.y});
        visited[taxi.y][taxi.x] = true;
        Person person = null;
        int distance = 0;

        // 현재 위치에 손님이 있다면 바로 태우고, bfs 실행 X
        if (map[taxi.y][taxi.x] < 0) {
            q.poll();
            person = new Person(-map[taxi.y][taxi.x], taxi.y, taxi.x);
        }

        while (!q.isEmpty()) {
            if (person != null) break;
            distance++;
            int size = q.size();
        }
        return true;
    }
}

class Taxi {
    int fuel;
    int y;
    int x;

    public Taxi(int fuel, int y, int x) {
        this.fuel = fuel;
        this.y = y;
        this.x = x;
    }
}

class Person {
    int num;
    int y;
    int x;

    public Person(int num, int y, int x) {
        this.num = num;
        this.y = y;
        this.x = x;
    }
}


