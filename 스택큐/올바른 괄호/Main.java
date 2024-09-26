import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //String s = "()()";
        String s = ")()(";
//        String s = "(()(";
        Solution solution = new Solution();

        System.out.println("sV1 = " + solution.solution(s));

        SolutionV2 solutionV2 = new SolutionV2();

        System.out.println("sV2 = " + solutionV2.solution(s));

        SolutionV3 solutionV3 = new SolutionV3();

        System.out.println("sV3 = " + solutionV3.solution(s));



    }
}