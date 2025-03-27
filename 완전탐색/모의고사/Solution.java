import java.util.*;

class Solution {
    public int[] solution(int[] answers) {    // {1,3,2,4,2}
        // [넘겨받은 배열의 값에] [반복되는 배열을 비교해서] 가장 많은 값을 가진 배열을 리턴
        // 가장 큰 값이 여러개 있을 경우, 오름차순 정렬

        int[] pattern1 = new int[]{1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {  // 1,2,3,4,5,1 -> 6
            if (answers[i] == pattern1[i % pattern1.length]) {
                score[0]++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                score[1]++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                score[2]++;
            }
        }
        int maxCnt = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (maxCnt == score[i]) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}

