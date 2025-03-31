import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(Arrays.toString(solution.solution(10, 2))); // -> return {4,3}
        System.out.println(Arrays.toString(solution.solution(8, 1))); // -> return {3,3}
        System.out.println(Arrays.toString(solution.solution(24, 24))); // -> return {8,6}

//        System.out.println(solution.solution(new String("011"))); // -> return {2}




    }
}
