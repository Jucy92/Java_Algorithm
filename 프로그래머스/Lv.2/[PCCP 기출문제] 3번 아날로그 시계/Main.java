import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution(0, 5, 30, 0, 7, 0));
        System.out.println(solution.solution(12,0,0,12,0,30));
        System.out.println(solution.solution(0,6,1,0,6,6));
        System.out.println(solution.solution(11,59,30,12,0,0));
        System.out.println(solution.solution(11,58,59,11,59,0));
        System.out.println(solution.solution(1,5,5,1,5,6));
        System.out.println(solution.solution(0,0,0,23,59,59));

    }
}
