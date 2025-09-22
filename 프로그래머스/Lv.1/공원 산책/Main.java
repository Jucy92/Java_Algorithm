import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println(Arrays.toString(solution.solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
        System.out.println(Arrays.toString(solution.solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"})));
    }
}
