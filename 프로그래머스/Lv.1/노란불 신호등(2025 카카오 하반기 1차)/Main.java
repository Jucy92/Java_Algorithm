import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        SolutionV2 sol2 = new SolutionV2();

        System.out.println(sol.solution(new int[][]{{2, 1, 2}, {5, 1, 1}}));
        System.out.println(sol.solution(new int[][]{{2, 3, 2}, {3, 1, 3}, {2, 1, 1}}));
        System.out.println(sol.solution(new int[][]{{3, 3, 3}, {5, 4, 2}, {2, 1, 2}}));
        System.out.println(sol.solution(new int[][]{{1,1,4}, {2,1,3}, {3,1,2}, {4,1,1}}));
    }
}
