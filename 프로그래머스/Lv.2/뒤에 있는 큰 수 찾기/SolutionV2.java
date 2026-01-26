import java.util.Stack;

class SolutionV2 {      // 시간 복잡도 O(n^2)
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
                answer[i] = -1;
            }
        }
        answer[numbers.length-1] = -1;

        return answer;
    }
}