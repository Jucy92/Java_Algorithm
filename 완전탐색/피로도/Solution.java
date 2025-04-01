class Solution {
    private int maxCount = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return maxCount;
    }
    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        if (count > maxCount) {
            maxCount = count;
        }
        // 모든 던전을 탐색했거나, 남은 피로도로 더 이상 던전을 탐험할 수 없으면 종료
        if (count == dungeons.length || k == 0) return;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
    }

}


