import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(Arrays.toString(solution.solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(solution.solution(new int[]{5, 0, 2, 7}));


    }
}
