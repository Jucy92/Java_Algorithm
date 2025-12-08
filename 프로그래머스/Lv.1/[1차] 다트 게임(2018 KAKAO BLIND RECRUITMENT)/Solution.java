import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];  // 각 라운드 점수 저장
        int round = -1;             // 현재 라운드 (-1부터 시작)

        // 1S*2T*3S
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            // 숫자인 경우 (새로운 라운드 시작)
            if (Character.isDigit(c)) {
                round++;
                if (c == '1' && dartResult.charAt(i + 1) == '0') {  // 테스트 케이스는 통과하긴 했는데, 안정성을 위해 i > 0 && i + 1 <dartResult.length() 도 추가해주면 좋다
                    scores[round] = 10;
                    i++;    // '0' 건너뜀
                } else {
                    scores[round] = c - '0';
                }
            // 보너스 처리
            } else {
                if (c == 'S') {
                    scores[round] = scores[round];  // 보기 좋게 하기 위해 추가
                } else if (c == 'D') {
                    scores[round] = (int) Math.pow(scores[round], 2);
                } else if (c == 'T') {
                    scores[round] = (int) Math.pow(scores[round], 3);
            // 옵션 처리
                } else if (c == '*') {
                    if (round > 0) {
                        scores[round - 1] *= 2;
                    }
                    scores[round] *= 2;
                } else if (c == '#') {
                    scores[round] *= -1;
                }
            }
        }

        return scores[0] + scores[1] + scores[2];
    }
}