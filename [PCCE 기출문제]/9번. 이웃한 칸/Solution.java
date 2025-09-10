import java.util.*;

public class Solution {

    public int solution(String[][] board, int h, int w) {
        // 1. 색 정보가 담긴  2차원 배열 board의 h,w 자리에 해당하는 색 정보를 추출
        // 2. 해당 자리에서 위 아래 좌 우에 같은 색이 있는지 확인하여 같은 색의 개수를 리턴
        int n, count = 0;
        n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        String color = board[h][w];
        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            if (nh >= 0 && nw >= 0 && nh <n && nw < n) {
                if (board[nh][nw].equals(color)) {
                    count++;
                }
            }

        }

        return count;
    }

}

