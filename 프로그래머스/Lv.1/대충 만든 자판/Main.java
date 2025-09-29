import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println((Arrays.toString(solution.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"}))));
        System.out.println((Arrays.toString(solution.solution(new String[]{"AA"}, new String[]{"B"}))));
        System.out.println((Arrays.toString(solution.solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"}))));
    }
}
