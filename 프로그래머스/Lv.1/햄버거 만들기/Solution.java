import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int count = 0;
        int idx = 0;
        int[] stack = new int[ingredient.length];

        for (int ing : ingredient) {
            stack[idx++] = ing;

            if (idx >= 4 && stack[idx - 4] == 1 && stack[idx - 3] == 2 && stack[idx - 2] == 3 && stack[idx - 1] == 1) {
                idx -= 4;
                count++;
            }
        }
        return count;
    }
}