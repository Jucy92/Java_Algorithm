import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solutionV2 = new SolutionV2();

        System.out.println(solution.solution(new int[]{1, 1, 1, 1, 1}, 3));    // -> return 5
        System.out.println(solutionV2.solution(new int[]{1, 1, 1, 1, 1}, 3));    // -> return 5
//        System.out.println(solution.solution(new int[]{4, 1, 2, 1}, 4));    // -> return 2
//        System.out.println(solutionV2.solution(new int[]{4, 1, 2, 1}, 4));    // -> return 2
    }
}
