import java.util.*;

class SolutionV2 {
    int maxCount = 0;

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        dfs(d,0, 0, 0, budget);

        return maxCount;
    }

    private void dfs(int[] d, int index, int sum, int count, int budget) {
        maxCount = Math.max(maxCount, count);  // sum 값을 넘겨주고 비교하는게 아니라 가능 할 때만 넘겨주기 때문에, 호출되고 바로 처리해도 괜찮.. => 내가 코드를 어떻게 짜냐에 따라 다르지..

        if (budget < sum) return;

        if (index == d.length) return;

        if (sum + d[index] <= budget) {
            dfs(d, index+1, sum+d[index], count+1, budget);
        }
//        dfs(d, index+1, sum, count, budget);  // 배열 정리 안했으면 필요하지만, 배열을 정렬 했기 때문에 위에서 통과가 안되면 뒤로는 다 budget보다 크기 떄문에 의미 없음..
    }

}