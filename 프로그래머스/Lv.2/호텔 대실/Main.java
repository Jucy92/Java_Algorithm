import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        System.out.println(solution.solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        System.out.println(solution.solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"},{"10:20", "12:30"}}));

    }
}
