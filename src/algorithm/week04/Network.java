package algorithm.week04;

public class Network {
    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
//            1. visited의 값을 초기화 해줍시다.
        visited = new boolean[n];
//            2. 정답의 개수를 반환할 변수를 선언해 줍시다.
        int answer = 0;
//            3. 전체를 탐색하며 <방문하지 않았다면>, dfs 를 실행하여 연결되어있는 모든것을 방문했다고 표시해줍니다.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
//            4. 방문하지 않은것을 발견할때마다, 하나의 네트워크를 발견한 셈이므로 정답의 개수에 1을 추가해줍니다.
                answer++;
            }
        }

//            6. 이후 계산한 값을 반환해 줍니다.
        return answer;
    }

    private static void dfs(int start, int[][] computers) {
        //1. 시작점을 방문하였다고 표시합니다.
        visited[start] = true;
        //2. 전체를 돌아보며 < 현재값(start)와 연결되어 있고, 방문하지 않은값 >들을 dfs를 돌려줍니다.
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[start][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
