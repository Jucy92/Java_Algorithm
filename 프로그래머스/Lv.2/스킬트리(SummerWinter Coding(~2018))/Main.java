import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(sol.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
        System.out.println(solution2.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
