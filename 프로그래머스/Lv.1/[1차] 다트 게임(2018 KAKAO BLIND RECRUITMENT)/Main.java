import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();

        System.out.println(solution.solution("1S2D*3T"));
        System.out.println(solution.solution("1D2S#10S"));
        System.out.println(solution.solution("1D2S0T"));
        System.out.println(solution.solution("1S*2T*3S"));
        System.out.println(solution.solution("1D#2S*3S"));
        System.out.println(solution.solution("1T2D3D#"));
        System.out.println(solution.solution("1D2S3T*"));


    }
}
