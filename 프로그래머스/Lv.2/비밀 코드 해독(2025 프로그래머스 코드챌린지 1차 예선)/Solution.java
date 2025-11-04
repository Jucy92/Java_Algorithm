import java.util.ArrayList;
import java.util.List;

class Solution_SC2 {
    int n;
    int count = 0;
    int[][] q;
    int[] ans;

    public int solution(int n, int[][] q, int[] ans) {
        /**
         * 초기 문제 접근 방식
         * 1. 기능 분리 - q[i] 안에서 비밀코드 생성(다 돌고 생성까지 끝내야함), ans[i] 개수 만큼 맞는지 검증 -> 모든 검증에 통과하면 result++
         * 2. 단계별 설계 - 근데.. i=0부터 q[i].length() 만큼 돌면서 만든다고 치면... 1~5까지 이거를 DFS 다 돌아..?
         * 그리고 두번 째 6~10 DFS 다 돌고? 그랬는데 세번째에서 검증이 안되면..? 경우에 수가 너무 많은데 다 낭비가 되잖아..?
         */
        /**
         * 정상적인 문제 접근 방식
         *  5개의 숫자를 뽑고, q[i]와 비교하며 ans[i] 개수와 동일한 지 체크하고 ans[m-1]와 같은 경우 count++
         */
        this.n = n;
        this.q = q;
        this.ans = ans;
        this.count = 0;

        dfs(1, new ArrayList<>());   // 최대 개수(5),

        return count;
    }

    private void dfs(int start, List<Integer> current) {
        if (current.size() == 5) {
            if (isValid(current)) {
                count++;
            }
            return;
        }
        if (n - start + 1 < 5 - current.size()) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            current.add(i);
            System.out.println("current = " + current);
            dfs(i + 1, current);
            current.remove(current.size() - 1);
        }

    }

    private boolean isValid(List<Integer> current) {
        return false;
    }
}