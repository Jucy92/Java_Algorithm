import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {2, 4}}));
        System.out.println(solution.solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {4, 2}, {4, 3}}));
        System.out.println(solution.solution(new int[][]{{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}}, new int[][]{{2, 3, 4, 5}, {1, 3, 4, 5}}));



    }
}
