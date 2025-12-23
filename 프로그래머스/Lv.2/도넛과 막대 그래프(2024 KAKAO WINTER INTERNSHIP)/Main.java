import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(Arrays.toString(solution.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})));
        System.out.println(Arrays.toString(solution.solution(
                new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})));
        //System.out.println(Arrays.deepToString(solution2.solution(new int[][]{{1}, {2}}, new int[][]{{3}, {4}})));


    }
}
