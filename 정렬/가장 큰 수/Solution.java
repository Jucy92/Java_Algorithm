import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        /**문제 접근
         * 1. numbers 값에 대해
         *    먼저 /10 나눈 값에 우선 순위 정하고
         *    그 값에 %10로 나누고 나머지가 큰 숫자 구분
         *    -> 숫자를 문자열로 변환하고 문자 더하기를 통해 정렬
         * 2. 큰 숫자부터 이어 붙이기
         */

        String[] strNumbers = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        if (strNumbers[0].equals("0")) {
            return "0";
        }
        for (String strNumber : strNumbers) {
            sb.append(strNumber);
        }
        return sb.toString();
    }
}