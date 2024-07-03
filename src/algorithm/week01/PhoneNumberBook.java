package algorithm.week01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneNumberBook {
    public boolean solution(String[] phone_book) {
        // 정렬
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

//        // 해시테이블
//        Set<String> prefixSet = new HashSet<>();
//        // 해시셋에 전화번호 저장
//        for (String number : phone_book) {
//            prefixSet.add(number);
//        }
//
//        for (String number : phone_book) {
//            for (int i = 0; i < number.length(); i++) {
//                String sub = number.substring(0, i);
//
//                if (prefixSet.contains(sub)) return false;
//            }
//        }
//        return true;



}
