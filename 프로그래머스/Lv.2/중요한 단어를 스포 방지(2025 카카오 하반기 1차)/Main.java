import java.util.*;

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        SolutionV2 sol2 = new SolutionV2();

        System.out.println(sol.solution("here is muzi here is a secret message", new int[][]{{0, 3}, {23, 28}}));
        //0~3 here 23~28 secret 공백 포함 XXXX is muzi here is a XXXXXX message
        System.out.println(sol.solution("my phone number is 01012345678 and may i have your phone number", new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}}));
        // my phXne numbr is 010123XXXX8 and XXXXXXhave your phXXXXXXXber
    }
}
