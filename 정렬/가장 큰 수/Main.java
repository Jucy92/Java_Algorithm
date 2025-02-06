import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution(new int[]{6, 10, 2})); // -> return [6210]
        System.out.println(solution.solution(new int[]{3, 30, 34, 5, 9})); // -> return [9534330]
        solution2.solution(new int[]{6, 10, 2}); // -> return [6210]
    }
}
