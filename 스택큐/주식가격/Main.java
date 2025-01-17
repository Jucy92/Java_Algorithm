import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution(new int[]{1, 2, 3, 2, 3})); // -> return [4, 3, 1, 1, 0]
        System.out.println(solution.solution(new int[]{1, 2, 3, 2, 3, 6})); // -> return [5, 4, 2, 2, 1, 0]
        System.out.println(solution.solution(new int[]{3, 2, 7, 9, 3})); // -> return [2, 3, 1, 0, 0]

        System.out.println(solution2.solution(new int[]{1, 2, 3, 2, 3})); // -> return [4, 3, 1, 1, 0]
        System.out.println(solution2.solution(new int[]{1, 2, 3, 2, 3, 6})); // -> return [5, 4, 1, 2, 1, 0]
        System.out.println(solution2.solution(new int[]{3, 2, 7, 9, 3})); // -> return [1, 3, 2, 1, 0]

        //
        /** 지금 내가 문제를 이해한 방법
         * 첫번 째 들어온 가격 -> 지나가면서 뒤에 들어온 주식들 보다 값이 크거나 같으면 가격이 떨어지지 않은 상태 유지 (계속 증가한 경우)
         * ... n 째 들어온 가격 -> 지나가다가 떨어진 주식을 보면 해당 초간 가격이 떨어진걸로 보고 해당 초는 증가하지 않음 (증가와 하락 있는 경우)
         * 마지막 째 들어온 가격 -> 뒤에 값이 없기에 그냥 0초
         */

        /** 원래 문제 의도
         * 가격이 떨어지지 않음 -> 지나간 초만큼 값 증가
         * 가격이 1번이라도 떨어짐 -> 지나가다 떨어진 시점의 초 값
         */
    }
}
