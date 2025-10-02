import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(Arrays.toString(
                solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"},
                        new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})
        ));

    }
}
