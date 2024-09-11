import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        //solution.solution(genres, plays);

        int[] result = solution.solution(genres, plays);
        System.out.println("result = " + Arrays.toString(result));
        int[] resultV2 = solution2.solution(genres, plays);
        System.out.println("result = " + Arrays.toString(resultV2));



    }
}