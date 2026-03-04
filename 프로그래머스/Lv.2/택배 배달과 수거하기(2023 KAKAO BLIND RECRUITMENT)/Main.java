import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(sol.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        System.out.println(sol.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
        System.out.println(sol.solution(4, 5, new int[]{4, 0, 0, 4, 4}, new int[]{0, 0, 0, 0, 12}));    //
    }
}
