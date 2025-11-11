import java.util.*;

class Solution {


    public String solution(String[] survey, int[] choices) {
        /**
         * choices = 질문 지 선택 위치 / choices[i]의 값은 1~7까지 있음
         * survey[i].charAt[j] 기준으로 점수(1~7) 부여
         * survey[i].charAt[j] 기준 choices[i] == 1->[j] +3, 2->[j]+2, 3->[j]+1, 4->0, 5->[j+1]+1, 6-> [j+1]+2, 7-> [j+1]+3
         * 필요 내용 -
         */
        Map<Character, Integer> testScore = new HashMap<>();
        String[] indexNum = new String[]{"RT", "CF", "JM", "AN"};
        for (String s : indexNum) {
            testScore.put(s.charAt(0), 0);
            testScore.put(s.charAt(1), 0);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];

            if (choice > 4) {
                char type = survey[i].charAt(1);
                testScore.put(type, testScore.get(type) + Math.abs(choice - 4));

            } else if (choice < 4) {
                char type = survey[i].charAt(0);
                testScore.put(type, testScore.getOrDefault(type, 0) + Math.abs(choice - 4));
            }
        }
//        System.out.println("testScore = " + testScore);

        for (int i = 0; i < 4; i++) {
            char prev = indexNum[i].charAt(0);
            char next = indexNum[i].charAt(1);
            if (testScore.get(prev) < testScore.get(next)) {
                sb.append(next);
            } else if (testScore.get(prev) > testScore.get(next)) {
                sb.append(prev);
            } else {    // 없거나(->0으로 다 기본 추가하면 케이스 삭제 가능), 같은 경우
                int prevIndex = prev - 'A';
                int nextIndex = next - 'A';
                sb.append(prevIndex < nextIndex ? prev : next);
            }
        }

        return sb.toString();
    }

}