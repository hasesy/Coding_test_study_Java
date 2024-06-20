package day01;

public class Linear_search {
    public static void main(String[] args) {
//      선형 탐색
        String[] arr = {"킥", "풉킥", "캬캬", "들켰다!", "호호", "메롱", "안돼~", "에베벱", "아닌데~", "집가고싶다"};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == "들켰다!") {
                System.out.println(i + 1 + "번만에 찾았다!");
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
