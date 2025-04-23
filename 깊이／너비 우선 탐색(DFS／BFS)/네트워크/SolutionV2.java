
class SolutionV2 {
    public int solution(int n, int[][] computers) { // DFS
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int[][] computers, boolean[] visited, int node) {  // {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}