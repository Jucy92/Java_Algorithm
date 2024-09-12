import java.util.Stack;

public class SolutionV2 {
    public Stack<Integer> solution(int []arr) {

        Stack<Integer> stack = new Stack<>();     // 스택으로 하면 아래 pop 포문 i--하면서 빼야함
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        return stack;   // 스택 자체를 반환 했을 때
    }
}