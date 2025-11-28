import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer=0;
        List<List<int[]>> robotPaths = new ArrayList<>();

        for (int[] route : routes) {
            List<int[]> path = new ArrayList<>();

            int[] current = points[route[0] - 1].clone();
            path.add(current.clone());  // 시작점 추가

            for (int i = 1; i < route.length; i++) {   // i=0은 위에서 시작 위치로 사용 / 1~length 까지는 도착해야할 위치
                int[] target = points[route[i] - 1];

                while (current[0] != target[0]) {
                    if (current[0] < target[0]) {
                        current[0]++;
                    } else {
                        current[0]--;
                    }
                    path.add(current.clone());
                }
                while (current[1] != target[1]) {
                    if (current[1] < target[1]) {
                        current[1]++;
                    } else {
                        current[1]--;
                    }
                    path.add(current.clone());
                }
            }
            robotPaths.add(path);
        }

        // 2. 최대 시간 구하기
        int maxTime = 0;
        for (List<int[]> path : robotPaths) {
            maxTime = Math.max(maxTime, path.size());
        }

        // 3. 각 시간마다 충돌 체크
        for (int time = 0; time < maxTime; time++) {
            Map<String, Integer> positionCount = new HashMap<>();
            for (List<int[]> path : robotPaths) {
                if (time < path.size()) {   // 최대시간보다 길이가 작은 경우 패스
                    int[] pos = path.get(time);
                    String key = pos[0] + "," + pos[1];
                    positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                }
            }
            for (Integer value : positionCount.values()) {
                if (value >= 2) {
                    answer++;
                }
            }
        }
        return answer;
    }
}