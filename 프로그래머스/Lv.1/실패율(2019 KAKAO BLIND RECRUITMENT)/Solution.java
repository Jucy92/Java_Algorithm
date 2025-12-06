import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        //stages = 시도하는 사람들
        // N = 5, stages = {2, 1, 2, 6, 2, 4, 3, 3}
        //2/4 = 0.5 => 3
        //1/2 = 0.5 => 4
        //3/7 = 0.42857142857142855 => 2
        //1/8 = 0.125   => 1
        //0/1 = 0.0 => 5
        // stageCounts = {0,1,3,2,1,0,1}
        // failureRate[0][0] = 1, failureRate[0][1] = 1/8
        int[] answer = new int[N];

        // 각 스테이지에 머물러 있는 플레이어 수 카운트
        int[] stageCounts = new int[N + 2]; // 해당 스테이지에 통과하지 못한 사람
        for (int stage : stages) {
            stageCounts[stage]++;
        }

        // 각 스테이지의 실패율을 계산
        double[][] failureRate = new double[N][2];  // [스테이지][실패율] => [N][0] = 스테이지 [N][1] = 실패율
        int total = stages.length;
        for (int i = 1; i <= N; i++) {
            failureRate[i - 1][0] = i;

            if (total == 0) {
                failureRate[i - 1][1] = 0;
            } else {
                failureRate[i - 1][1] = (double) stageCounts[i] / total;
                total -= stageCounts[i];
            }
        }
        //System.out.println("failureRate = " + Arrays.deepToString(failureRate));

        // 실패율 기준 내림차순 정렬, 같으면 스테이지 번호 오름차순
        Arrays.sort(failureRate, (a, b) -> {
            if (a[1] != b[1]) {
                return Double.compare(b[1], a[1]);  // 실패율 내림차순
            }
            return Double.compare(a[0], b[0]);      // 스테이지 번호 오름차순
        });
        //System.out.println("failureRate = " + Arrays.deepToString(failureRate));

        for (int i = 0; i < failureRate.length; i++) {
            answer[i] = (int) failureRate[i][0];
        }

        return answer;
    }
}