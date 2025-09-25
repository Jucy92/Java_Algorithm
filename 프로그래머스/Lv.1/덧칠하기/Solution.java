import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] painted = new boolean[n + 1];
        int count = 0;

        for (int pos : section) {

            if (painted[pos]) {
                continue;
            }


            for (int i = pos; i < pos + m && i <= n; i++) {
                painted[i] = true;
            }

            count++;
        }
        return count;
    }
}