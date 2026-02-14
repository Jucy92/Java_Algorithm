import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        int n1 = 3;
        int ret1 = solution.solution(n1);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int ret2 = solution.solution(n2);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

    }
}
