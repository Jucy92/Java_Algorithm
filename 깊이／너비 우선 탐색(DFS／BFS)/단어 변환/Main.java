import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solutionV2 = new SolutionV2();

        long startTime = System.currentTimeMillis();    // nanoTime() 을 사용하면 더 정교한 초 확인 가능
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));    // -> return 5
        System.out.println(solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));    // -> return 5
        long endTime = System.currentTimeMillis();
        long dfsTime = endTime - startTime;

        System.out.println("dfsTime = " + dfsTime);
        //System.out.println("endTime = " + endTime);
        //System.out.println("startTime = " + startTime);

        /*
        long startTimeV2 = System.currentTimeMillis();
        //System.out.println(solutionV2.solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));    // -> return 5
        long endTimeV2 = System.currentTimeMillis();
        long bfsTime = endTimeV2 - startTimeV2;


        System.out.println("bfsTime = " + bfsTime);
        //System.out.println("endTime = " + endTimeV2);
        //System.out.println("startTime = " + startTimeV2);
         */
    }
}
