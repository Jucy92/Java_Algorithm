import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        Solution solution = new Solution();

        //int[] result = solution.solution(arr);
        //System.out.println("result = " + Arrays.toString(result));
        System.out.println(Arrays.toString(solution.solution((arr))));


    }
}