import java.util.*;

class SolutionV2 {  // 스택을 사용해 편하게 접근
    public int solution(int[] ingredient) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for (int ing : ingredient) {
            stack.push(ing);

            if (stack.size() >= 4) {
                int size = stack.size();
                if ((stack.get(size - 4) == 1) && (stack.get(size - 3) == 2) && (stack.get(size - 2) == 3) && (stack.get(size - 1) == 1)) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    count++;
                }
            }
        }
        return count;
    }
}