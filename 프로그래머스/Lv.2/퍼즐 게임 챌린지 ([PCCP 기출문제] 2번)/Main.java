import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution(new int[]{1, 5, 3}, new int[]{2,4,7}, 30));
        System.out.println(solution.solution(new int[]{1,4,4,2}, new int[]{6,3,8,2}, 59));
        System.out.println(solution.solution(new int[]{1, 99_999, 100_000, 99_995}, new int[]{9999, 9001, 9999, 9001}, 3_456_789_012L));


    }
}
