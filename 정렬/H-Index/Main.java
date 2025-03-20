import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution(new int[]{3, 0, 6, 1, 5})); // -> return 3
        System.out.println(solution.solution(new int[]{6, 2, 9, 7, 1})); // -> return 3
        System.out.println(solution.solution(new int[]{6, 8, 8, 9, 8 })); // -> return 3
//        System.out.println(solution.solution(new int[]{7,1,6,0,6})); // -> return 3
//        System.out.println(solution.solution(new int[]{7, 15, 9, 0, 4})); // -> return 3

    }
}
