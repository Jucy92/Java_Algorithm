import java.util.*;

class SolutionV2 {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return explore(k, dungeons, visited);
    }

    private int explore(int k, int[][] dungeons, boolean[] visited) {
        int max = 0;    // max 값은 각 depth 반복문 종료 시점에 저장
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                int current = explore(k - dungeons[i][1], dungeons, visited);   // current 값은 가장 아래 depth까지 갔다 올 때 리턴
                if (current + 1 > max) {
                    max = current + 1;
                }
                visited[i] = false;
            }
        }
        return max;
    }
}
/**
 * k = 현재 피로도 dungeons [] = 1~8 던전 개수, dungeons[][] = 피로도 정보, [][0] = 최소 필요 피로도, [][1] = 소모 피로도
 * 최대한 던전을 많이 돌 수 있는 경우의 수를 찾아야함
 * k >= dungeons[i][0]
 */

