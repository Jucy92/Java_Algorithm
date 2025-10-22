import java.util.*;

class SolutionV2 {
    private int minATrace = Integer.MAX_VALUE;
    private int[][] info;
    private int n, m;

    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        this.info = info;

        dfs(0, 0, 0);

        return minATrace == Integer.MAX_VALUE ? -1 : minATrace;
    }

    private void dfs(int item, int aTrace, int bTrace) {
        // 가지치기: 이미 찾은 최솟값보다 A흔적이 많으면 탐색 중단
        if (aTrace >= minATrace) return;
        if (item == info.length) {
            minATrace = Math.min(aTrace, minATrace);
            return;
        }
        int currentA = info[item][0];
        int currentB = info[item][1];
        if (aTrace + currentA < n) {
            dfs(item + 1, aTrace + currentA, bTrace);
        }
        if (bTrace + currentB < m) {
            dfs(item + 1, aTrace, bTrace + currentB);
        }

    }
}