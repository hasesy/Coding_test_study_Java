package algorithm.week02;

public class StringCompression {
    public int solution(String s) {
        int answer = s.length();

        if (s.length() == 1) return 1;

        for (int cut = 1; cut <= s.length() / 2; cut++) {
            StringBuilder sb = new StringBuilder(); // 문자열을 만들기 위함
            String front = s.substring(0, cut);

            int count = 1; // 중복 개수

            for (int j = cut; j < s.length(); j += cut) {
                String back;
                if (j + cut <= s.length()) {
                    back = s.substring(j, j + cut);
                } else {
                    back = s.substring(j, s.length());
                }

                if (front.equals(back)) count++;
                else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(front);
                    front = back;
                    count = 1;
                }
            }
            if (count > 1) {
                sb.append(count);
            }
            sb.append(front);

            answer = Math.min(answer, sb.length()); // 둘 중 더 작은 게 저장됨
        }

        return answer;
    }
}
