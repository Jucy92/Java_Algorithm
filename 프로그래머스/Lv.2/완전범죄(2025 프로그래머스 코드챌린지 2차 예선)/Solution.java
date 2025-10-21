import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        boolean[][][] dp = new boolean[len + 1][n][m];
        dp[0][0][0] = true;


        for (int i = 0; i < len; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if(!dp[i][x][y]) continue;

                    if (x + aTrace < n) {
                        dp[i+1][x+aTrace][y] = true;    // 110 -> 230, 213 ... 이런식으로 늘려나가면서 체크
                    }
                    if (y + bTrace < m) {
                        dp[i+1][x][y+bTrace] = true;    // 102 -> 222, 205(x)
                    }

                }
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (dp[len][x][y]) {    // 마지막까지 도달한 값들 중에 최소 값이 제일 먼저 나옴
                    return x;
                }
            }
        }
        return -1;
    }

}
