import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})); // -> return 4000
        System.out.println(solution.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // -> return 120


    }
}
