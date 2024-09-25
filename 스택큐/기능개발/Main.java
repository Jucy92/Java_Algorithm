import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[] progresses = {93, 30, 55};
        //int[] speeds = {1, 30, 5};
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Solution solution = new Solution();

        System.out.println("result = " + Arrays.toString(solution.solution(progresses, speeds)));
        //System.out.println(solution.solution(progresses, speeds));   solution 반환 타입이 List 일 경우

    }
}