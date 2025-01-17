import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class SolutionV2 {       // 복잡도 - O(n)

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 주식 가격을 순회하며 스택을 활용
        for (int i = 0; i < n; i++) {
            // 현재 가격이 이전 가격보다 작으면 스택에서 꺼내 처리
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;  // i = 3 idx = 3 answer[3] = 0
            }
            stack.push(i);
        }

        // 스택에 남아있는 값 처리 (끝까지 떨어지지 않은 경우)
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - idx - 1;  // 총 길이에서 - 인덱스 위치만큼 빼고 -1(인덱스가 0부터 시작했기 때문에)
        }

        System.out.println(getClass().getSimpleName()+ " = "  + Arrays.toString(answer));
        return answer;
    }
}