import java.util.*;

class SolutionV2 {

    int count = 0;

    public int solution(int[] nums) {
        dfs(nums, 0, 0, 0);

        return count;
    }

    private void dfs(int[] nums, int index, int sum, int combination) {

        if (combination == 3) {
            if (isDecimal(sum)) {
                count++;
            }
            return;
        }
        if (index >= nums.length) return;

        for (int i = index; i < nums.length; i++) {
            dfs(nums, i + 1, sum + nums[i], combination + 1);   // 여기서는 위에 조건으로 종료되더라도, nums.length 까지 반복함
        }

        //dfs(nums, index+1, sum+nums[index], combination+1);     // 여기는 뒤에 확인해야할 값이 있더라도 뒷 처리 안해줌

        //dfs(nums, index + 1, sum, combination);                                 // 그래서 이걸 명시적으로 추가해서 뒷 작업을 이어서 하게 해야함


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