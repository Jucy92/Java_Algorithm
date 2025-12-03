import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int move : moves) {
            int col = move - 1;

            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {
                    int doll = board[row][col];
                    board[row][col] = 0;

                    //여기서 바로 값 비교
                    if (!stack.isEmpty() && stack.peek() == doll) { // 비어있지 않고, peek가 같으면 팡!
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(doll);
                    }
                    break;
                }
            }
        }


        return count;
    }
}