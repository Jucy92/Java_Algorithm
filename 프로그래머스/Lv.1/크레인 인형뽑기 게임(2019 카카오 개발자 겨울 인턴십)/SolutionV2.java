
import java.util.Stack;

class SolutionV2 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int n = board.length;

        for (int move : moves) {
            for (int i = 0; i < n; i++) {
                if (board[i][move - 1] != 0) {
                    stack.push(board[i][move - 1]);
                    board[i][move - 1] = 0;
                    break;
                }
            }
            if (stack.size() > 1) {

                if (stack.peek().equals(stack.get(stack.size() - 2))) {
                    count+=2;
                    stack.pop();
                    stack.pop();
                }
            }
        }


        return count;
    }
}