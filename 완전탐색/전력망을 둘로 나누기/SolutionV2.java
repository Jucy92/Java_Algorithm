import java.util.*;

class SolutionV2 {
    List<Integer>[] adj;

    boolean[] visited;

    public int solution(int n, int[][] wires) {
        adj = new ArrayList[n + 1];

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            adj[v1].remove(Integer.valueOf(v2));
            adj[v2].remove(Integer.valueOf(v1));

            visited = new boolean[n + 1];

            int count = dfs(v1);
            //System.out.println("adj["+v1+"] 일 때 count = " + count);


            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff); // 1 : 7

            adj[v1].add(v2);
            adj[v2].add(v1);

        }

        return minDiff;
    }

    private int dfs(int node) {

        visited[node] = true;
        int count = 1;
        //System.out.println("adj["+node+"] = " + adj[node]);

        for (Integer num : adj[node]) { // 2-> 7(x), 1(o)
            if (!visited[num]) {
                count += dfs(num);
            }
        }
        visited[node] = false;


        return count;
    }
}