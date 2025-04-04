import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();
        SolutionV3 solution3 = new SolutionV3();

//        System.out.println(solution.solution(9, new int[][]{{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}})); // -> return 3
//        System.out.println(solution.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}})); // -> return 0
        System.out.println(solution.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}})); // -> return 1
        System.out.println(solution3.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}})); // -> return 1


//        System.out.println(solution.solution(new String("011"))); // -> return {2}




    }
}
