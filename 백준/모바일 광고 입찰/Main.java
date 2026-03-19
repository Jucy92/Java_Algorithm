import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        SolutionV2 sol2 = new SolutionV2();

        System.out.println(sol2.solution(3,2, new String[]{"3 1", "2 1", "1 2"}));
        System.out.println(sol2.solution(3,2, new String[]{"10 30", "21 19", "10 12"}));
    }
}
