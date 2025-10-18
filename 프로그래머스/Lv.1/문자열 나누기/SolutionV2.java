import java.util.*;

class SolutionV2 {      // 반복문 한번으로 끝내기
    public int solution(String s) {
        char prev = '1'; // 플래그: '1'이면 "새 구간 시작해야 함"을 의미
        int same = 0, different = 0, answer = 0;

        for (char c : s.toCharArray()) {
            if (prev == '1') {
                // 새 구간의 시작! 현재 문자를 첫 글자(x)로 설정
                prev = c;        // 첫 글자를 현재 문자로 설정
                same++;          // 첫 글자 개수 1개
                answer++;        // 새로운 구간이므로 답 +1
            } else if (prev == c) {
                // 현재 문자가 첫 글자와 같음
                same++;
            } else {
                // 현재 문자가 첫 글자와 다름
                different++;
            }

            // 첫 글자 개수와 다른 글자 개수가 같아지면 구간 끝!
            if (same == different) {
                prev = '1';      // 다시 플래그로 설정 (다음 구간 준비)
                same = 0;
                different = 0;
            }
        }

        return answer;
    }
}