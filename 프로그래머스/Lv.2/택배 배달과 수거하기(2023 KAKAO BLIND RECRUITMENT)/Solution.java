class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dRemain = 0, pRemain = 0;

        for (int i = n - 1; i >= 0; i--) {
            dRemain += deliveries[i];
            pRemain += pickups[i];

            while (dRemain > 0 || pRemain > 0) {    // 한쪽의 계산이 남아있다면 다른쪽이 음수가 되도 진행... 그게 나중에 앞쪽으로 가면서 통과했던 값에 대해서 처리..
                dRemain -= cap;
                pRemain -= cap;
                answer += (long)(i+1)*2;
            }
        }

        return answer;
    }
}