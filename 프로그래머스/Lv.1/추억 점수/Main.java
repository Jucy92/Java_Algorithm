import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}
                , new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}})));

        System.out.println(Arrays.toString(solution.solution(new String[]{"kali", "mari", "don"}, new int[]{11,1,55}
                , new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}})));

        System.out.println(Arrays.toString(solution.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}
                , new String[][]{{"may"},{"kein", "deny", "may"}, {"kon", "coni"}})));
    }
}
