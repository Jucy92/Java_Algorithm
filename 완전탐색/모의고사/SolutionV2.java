import java.util.*;

class SolutionV2 {
    public List<Integer> solution(int[] answers) {    // {1,3,2,4,2}
        // [넘겨받은 배열의 값에] [반복되는 배열을 비교해서] 가장 많은 값을 가진 배열을 리턴
        // 가장 큰 값이 여러개 있을 경우, 오름차순 정렬

        // -> 문제점1. answers 값이 배열보다 큰 경우 ArrayIndexOutOfBoundsException 예외 발생

        int[] SuPoJa1 = new int[]{1, 2, 3, 4, 5};
        int[] SuPoJa2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] SuPoJa3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == SuPoJa1[i]) {
                cnt1++;
            }if (answers[i] == SuPoJa2[i]) {
                cnt2++;
            }if (answers[i] == SuPoJa3[i]) {
                cnt3++;
            }
        }
        int maxCnt = Math.max(cnt1, Math.max(cnt2, cnt3));

        if (maxCnt == cnt1) list.add(1);
        if (maxCnt == cnt2) list.add(2);
        if (maxCnt == cnt3) list.add(3);

        return list;
    }
}

