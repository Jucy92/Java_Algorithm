import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solutionV2 = new SolutionV2();

        System.out.println(solution.solution(new int[][]{{0, 3}, {1, 9}, {3, 5}})); // -> return 8
        System.out.println(solution.solution(new int[][]{{0, 3}, {5, 12}, {5, 9}})); // -> return 11

        System.out.println(solutionV2.solution(new int[][]{{0, 3}, {1, 9}, {3, 5}})); // -> return 8
        System.out.println(solutionV2.solution(new int[][]{{0, 3}, {5, 12}, {5, 9}})); // -> return 11

        /**
         * 문제 접근 방식
         * 우선 순위 큐 사용, 처리 우선 순위 = 처리시간 짧은 것, 빠른 작업 요청, 작업 번호 작은 것
         * 처리 우선 순위에 대한 Job 클래스 생성 (processingTime, startDelay, sequence) 순서대로
         * 0,3 -> 0초시작 3초 걸림 -> 3초
         * 1,9 -> 1초 부터 시작 9초 걸림 -> 3초에 시작하면 12초 --> 처리시간 밀림 --> 8초 시작 17초 종료
         * 3,5 -> 3초에 시작 5초 걸림(8) -> 3초에 바로 들어와서 시작 -> 8초 -> 8-3 = 5
         */
    }
}
