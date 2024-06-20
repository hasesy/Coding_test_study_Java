package day01;

import java.util.Scanner;
import java.util.Arrays;


public class Binary_search {
    public static void main(String[] args) {
        //        이분 탐색
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();  // 배열의 크기 N을 입력 받음
        int[] arr = new int[N];  // 크기가 N인 정수 배열을 선언

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();  // 배열의 각 요소에 입력 받은 값을 저장
        }

        // 배열의 값을 출력

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);  // 각 요소를 한 줄씩 출력
        }

        System.out.println();
        // 배열을 정렬
        Arrays.sort(arr);

        // 정렬된 배열의 값을 출력
        System.out.print("Sorted array:");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);  // 각 요소를 한 줄씩 출력
        }

        int M = in.nextInt(); // 5

        // 입력 값에 따라 즉시 처리
        for (int i = 0; i < M; i++) {
            binarySearch(arr, in.nextInt());
        }

    }

    //(정렬된 배열:arr, 찾고자 하는 값:key)
    public static void binarySearch(int[] arr, int key){
        int lo = 0;                 // 탐색 범위의 왼쪽 끝 인덱스
        int hi = arr.length - 1;    // 탐색 범위의 오른쪽 끝 인덱스

        // lo가 hi보다 커지기 전까지 반복한다.
        while (lo <= hi) {
            int mid = (lo + hi) / 2;    // 중간위치를 구한다.

            // key값이 중간 위치의 값보다 작을 경우
            if (key < arr[mid]) {
                hi = mid - 1;
            }
            // key값이 중간 위치의 값보다 클 경우
            else if (key > arr[mid]) {
                lo = mid + 1;
            }
            // key값과 중간 위치의 값이 같을 경우
            else {
                System.out.println(1);
                return;
            }
        }

        // 찾고자 하는 값이 존재하지 않을 경우
        System.out.println(0);
    }
}

