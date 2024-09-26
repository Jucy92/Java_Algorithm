import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionV2 {       // 스택/큐 없이 그냥 최적화 코드 - feat.GPT
    boolean solution(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            // 중간에 count가 음수가 되면 짝이 맞지 않음
            if (count < 0) {
                return false;
            }
        }
        // 최종적으로 count가 0이면 올바른 괄호, 아니면 false
        return count == 0;
    }
}