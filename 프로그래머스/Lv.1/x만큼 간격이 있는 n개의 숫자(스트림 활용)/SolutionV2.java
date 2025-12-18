import java.util.*;

class SolutionV2 {  // 속도는 덧셈>곱셈 이지만 단순 작업에서는 별 차이 없음..
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
//        long sum = x;
        for (int i = 0; i < n; i++) {
//            answer[i] = sum;
//            sum += x;
            answer[i] = (long) x * (i + 1);
        }
        return answer;
    }

}