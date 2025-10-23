class Solution {
    public int solution(int[] players, int m, int k) {
        int totalAdditions = 0;
        int time = players.length;
        int[] runningServer = new int[time];
        // 1. 증설 서버 구하는 방식... => players[i]/m -> 몫이 증설해야하는 서버
        // 2. 시간처리.. => (필수 서버 개수 - 돌아가고 있는 서버) 를 i+k 만큼 돌아야하는 runningServer[time] 추가

        for (int i = 0; i < time; i++) {
            int requiredServers = players[i] / m;
            int serverToAdd = Math.max(0, requiredServers - runningServer[i]);

            if (serverToAdd > 0) {
                totalAdditions += serverToAdd;
                for (int j = i; j < Math.min(24,i + k); j++) {
                    runningServer[j] += serverToAdd;
                }
            }
        }
        return totalAdditions;
    }
}
