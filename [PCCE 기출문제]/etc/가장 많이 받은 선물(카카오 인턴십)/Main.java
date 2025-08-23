import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
        System.out.println(solution.solution(new String[]{"joy", "brad", "alessandro", "conan", "david"},
                new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));
        System.out.println(solution.solution(new String[]{"a", "b", "c"},
                new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}));

    }
}
