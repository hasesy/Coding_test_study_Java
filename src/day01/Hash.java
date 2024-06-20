package day01;

import java.io.IOException;
import java.util.HashMap;

public class Hash {
    public static void main(String[] args) throws IOException {
        //해시맵을 선언해 봅시다
        HashMap<Integer, String> myMap = new HashMap<>();

        //1. 데이터를 집어넣는 put, 데이터를 가져오는 get
        myMap.put(1, "안녕하세요");
        System.out.println(myMap.get(1));

        //2. 데이터를 삭제하는 remove, clear
        myMap.put(2, "뭘봐임마");
        myMap.remove(2); //지정삭제
        System.out.println(myMap.get(2));
        myMap.clear(); //전체삭제
        System.out.println(myMap.get(1));

        //3. 데이터를 수정하는 replace
        myMap.put(1, "꽁꽁");
        System.out.println(myMap.get(1));
        myMap.replace(1, "얼어붙은");
        System.out.println(myMap.get(1));
        myMap.replace(1, "얼어붙은", "한강위로");
        System.out.println(myMap.get(1));
        myMap.replace(1, "고양이가");
        System.out.println(myMap.get(1));
        myMap.replace(1, "고양이가", "걸어다닙니다.");
        System.out.println(myMap.get(1));

        //4. 데이터를 확인하는 containsKey, isEmpty, size
        System.out.println(myMap.containsKey(1));
        System.out.println(myMap.isEmpty());
        myMap.clear();
        System.out.println(myMap.isEmpty());
        System.out.println(myMap.size());

        //5. 실습
        //노래가사를 Hash의 put을 통해 HashMap에 저장하고,
        //Get과 반복문, 그리고 println을 통해서 출력해보세요.
        myMap.put(1, "Su su su Supernova");
        myMap.put(2, "Nova");
        myMap.put(3, "Can't stop hyperstellar");
        myMap.put(4, "원초 그걸 찾아");
        myMap.put(5, "Bring the light of a dying star");
        myMap.put(6, "불러낸 내 우주를 봐 봐");
        for (int i = 1; i <= 6; i++) {
            System.out.println(myMap.get(i));
        }
    }
}
