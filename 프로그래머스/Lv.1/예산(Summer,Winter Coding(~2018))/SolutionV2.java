import java.util.*;

class SolutionV2 {
    int[] d;
    int budget;
    int count;
    boolean[] visited;
    public int solution(int[] d, int budget) {
        count = 0;
        int answer = 0;
        int sum =0;
        this.d = d;
        this.budget = budget;
        this.visited = new boolean[d.length];

        dfs(0,0);

        return count;
    }

    private void dfs(int num, int depth) {
//        System.out.println("num = " + num + ", depth = " + depth);
        if (num > budget) {
            return;
        }
        count = Math.max(count, depth);
        for (int i = 0; i < d.length; i++) {
//            System.out.println("visited["+i+"] = " + visited[i]);
            if (!visited[i]) {
                visited[i] = true;
                dfs(num+d[i], depth+1);
                visited[i] = false;
            }
        }

    }
}