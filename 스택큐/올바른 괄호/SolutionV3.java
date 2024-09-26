import java.util.Stack;

public class SolutionV3 {       // 스택을 사용해서 - feat.GPT
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        // 문자열의 각 문자를 순회
        for (char c : s.toCharArray()) {
            // '('일 경우 스택에 추가
            if (c == '(') {
                stack.push(c);
            }
            // ')'일 경우
            else {
                // 스택이 비어있다면 짝이 맞지 않으므로 false 반환
                if (stack.isEmpty()) {
                    return false;
                }
                // '('와 짝을 맞추기 위해 스택에서 pop
                stack.pop();
            }
        }

        // 모든 작업이 끝난 후 스택이 비어 있으면 올바른 괄호, 비어있지 않으면 false 반환
        return stack.isEmpty();
    }
}