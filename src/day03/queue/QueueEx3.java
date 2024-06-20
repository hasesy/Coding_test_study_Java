package day03.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class QueueEx3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> Group = new LinkedList<>();

        for(int i=1; i<=N; i++){
            Group.offer(i);
        }

        int count =1;
        while(!Group.isEmpty()) {
            int person = Group.poll();
            if (count == K) {
                System.out.printf(person + " ");
                count = 1;
            }
            else{
                Group.offer(person);
                count++;
            }
        }
        br.close();
    }
}
