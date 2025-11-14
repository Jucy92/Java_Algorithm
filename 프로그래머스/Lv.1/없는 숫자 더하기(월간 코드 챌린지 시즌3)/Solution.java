import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        boolean[] exists = new boolean[10];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            exists[numbers[i]] = true;
        }

        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                sum += i;
            }
        }

        return sum;
    }
}