class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 0;

        // 최대 난이도 찾기
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }

        int answer = right;

        // 이분 탐색
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSolve(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;  // 더 작은 숙련도 탐색
            } else {
                left = mid + 1;   // 더 큰 숙련도 필요
            }
        }

        return answer;
    }

    private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int timePrev = (i == 0) ? 0 : times[i - 1];

            if (diffs[i] <= level) {
                // 난이도가 숙련도 이하면 바로 해결
                totalTime += times[i];
            } else {
                // 난이도가 숙련도보다 높으면 틀리는 횟수만큼 반복
                int mistakes = diffs[i] - level;
                totalTime += (long)(times[i] + timePrev) * mistakes + times[i];
            }

            // 조기 종료 최적화
            if (totalTime > limit) {
                return false;
            }
        }

        return totalTime <= limit;
    }
}