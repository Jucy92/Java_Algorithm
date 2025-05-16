import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solutionV2 = new SolutionV2();

        long startTime = System.currentTimeMillis();    // nanoTime() 을 사용하면 더 정교한 초 확인 가능
        //System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));    // -> return 17
        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "AAA"}, {"ATL","SFO"}})));    // -> return 17
        //System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));    // -> return 17
        long endTime = System.currentTimeMillis();
        long dfsTime = endTime - startTime;

        System.out.println("dfsTime = " + dfsTime);
        //System.out.println("endTime = " + endTime);
        //System.out.println("startTime = " + startTime);

        /*
        long startTimeV2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(solutionV2.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));    // -> return 5
        long endTimeV2 = System.currentTimeMillis();
        long bfsTime = endTimeV2 - startTimeV2;


        System.out.println("bfsTime = " + bfsTime);
        //System.out.println("endTime = " + endTimeV2);
        //System.out.println("startTime = " + startTimeV2);
         */


    }
}
