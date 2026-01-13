import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution.solution(new int[]{2, 2, 2, 3, 3}, 6)));


    }
}
