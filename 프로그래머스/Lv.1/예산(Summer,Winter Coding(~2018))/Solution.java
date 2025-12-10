import java.util.*;

class Solution {

    public int solution(int[] d, int budget) {
        int count = 0;
        int sum = 0;
        Arrays.sort(d);

        for (int amount : d) {
            sum += amount;
            if (sum <= budget) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}