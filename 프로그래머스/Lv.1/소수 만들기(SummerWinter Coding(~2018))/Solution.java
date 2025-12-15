import java.util.*;

class Solution {


    public int solution(int[] nums) {
        int count = 0;

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isDecimal(sum)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isDecimal(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i*i <= num; i+=2) {
            if (num % i == 0) return false;
        }
        return true;
    }

}