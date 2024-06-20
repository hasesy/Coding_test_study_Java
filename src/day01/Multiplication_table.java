package day01;

import java.util.Scanner;


public class Multiplication_table {
    public static void main(String[] args) {
//                구구단을 위한 스캐너
        Scanner scanner = new Scanner(System.in);
        int dan = scanner.nextInt();

//        입력받은 수의 단까지만 구구단_for문
        for (int i = 1; i <= dan; i++) {
            System.out.printf("%d단 입니다.\n", i);
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d\n", i, j, j * i);
            }
        }

//        입력받은 수의 단까지만 구구단_while문
        int index = 1;
        while (index <= dan) {
            System.out.printf("%d단 입니다.\n", index);
            for(int i = 1; i <= 9; i++) {
                System.out.printf("%d * %d = %d\n", index, i, (index*i));
            }
            index++;
        }

//        for문으로 구구단 만들기
        for(int i = 1; i <= 9; i++) {
            System.out.printf("%d단 입니다.\n",i);
            for(int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d\n", i, j, (i*j));
            }
        }

//        while문으로 구구단 만들기
//        int index = 1;
//        while (index <= 9) {
//            System.out.printf("%d단 입니다.\n", index);
//            for(int i = 1; i <= 9; i++) {
//                System.out.printf("%d * %d = %d\n", index, i, (index*i));
//            }
//            index++;
//        }
    }
}
