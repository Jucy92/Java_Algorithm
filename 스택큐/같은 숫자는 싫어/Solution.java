import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        Deque<Integer> stack = new ArrayDeque<>();
        //Stack<Integer> stack = new Stack<>();     // 스택으로 하면 아래 pop 포문 i--하면서 빼야함
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        System.out.println("stack = " + stack);
        answer = new int[stack.size()];

        /* pollLast로 풀었을 때
        for (int i = 0; i < answer.length ; i++) {
            answer[i] = stack.pollLast();
        }
        */
        // pop 으로 풀었을 때
        for (int i = answer.length -1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}