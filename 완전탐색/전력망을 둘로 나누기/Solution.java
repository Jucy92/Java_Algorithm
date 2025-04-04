import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private boolean[] visited;
    public int solution(int n, int[][] wires) { // {1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}
        // n =송전 탑 개수, wires =송전탑과 탑의 연결 전선
        // adj = new ArrayList[]{new ArrayList<>(n + 1)}; // 이렇게하면 하나밖에 생성이 안되는구나.. 그 1개 리스트의 크기가 n+1인거고
        // initialCapacity => 확장 가능 개수 제한하는거였지.. 원래는 무한으로 추가되는데 저거 설정하면 add 했을 때 그 범위를 넘어갈 수 없는거지..

        adj = new ArrayList[n+1]; // 송전탑 숫자만큼 크기의 리스트 생성 1부터~ n개
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {  // 모든 탑 연결
            int v1 = wire[0];
            int v2 = wire[1];

            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        //System.out.println("adj = " + Arrays.toString(adj));
        int minDiff = Integer.MAX_VALUE;    // 최소 차이를 구하기 위한 변수

        for (int[] wire : wires) {  // 탑을 하나씩 끊으면서 연결되어 있는 탑 개수 구하고, 그중 최소 값을 찾는다.
            int v1 = wire[0];
            int v2 = wire[1];

            //adj[v1].remove(v2);   // 그냥 이렇게해버리면 v2의 숫자에 해당하는 인덱스의 값이 지워짐 -> 인덱스 값이 아니라 값이 지워져야함
            adj[v1].remove(Integer.valueOf(v2));
            adj[v2].remove(Integer.valueOf(v1));

            // 한쪽 서브트리의 크기 계산
            visited = new boolean[n + 1];       // 매번 생성해서 visited[node] = false; 해줄 필요가 없음
            int count = dfs(v1);
            
            // 한쪽 node 계산한 결과가 최소 값인지 체크
            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(diff, minDiff);

            // 끊었던 선 연결(원복)
            adj[v1].add(v2);
            adj[v2].add(v1);

        }

        return minDiff;
    }

    private int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                count += dfs(neighbor);
            }
        }

        return count;
    }
}
/**
 * 1. 송전탑에 대해서 wires 정보로 다 연결
 * 2. 중앙에서 나누기
 */