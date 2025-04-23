import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    private void bfs(int[][] computers, boolean[] visited, int start) {  // {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (int i = 0; i < computers.length; i++) {
                if (computers[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }

        }


    }
}