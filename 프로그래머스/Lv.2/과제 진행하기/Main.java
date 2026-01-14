import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SolutionV2 solution = new SolutionV2();
        Solution solution2 = new Solution();

//        System.out.println(Arrays.toString(solution.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}})));
        //System.out.println(Arrays.toString(solution.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}})));
        System.out.println(Arrays.toString(solution.solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}})));


    }
}
