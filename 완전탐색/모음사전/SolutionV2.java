import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionV2 {      // 처음 조건부터 잘못잡아서 다시 풀었음
    String[] values = {"A", "E", "I", "O", "U"};
    String[] parts;
    int count = 0;
    int index = 0;

    public int solution(String word) {  // AAAAE -> 6

        int answer = 0;
        int depth = 0;

        parts = word.split("");


        bfs(depth, "", word);
        return answer;
    }

    private void bfs(int depth, String concat, String word) {    // "", AAAAE, 0 / A, - , 1 / AA,2 / AAA, 3 / AAAA,4 / AAAAA,5 / AAAAAA~U, 6 바로리턴 / AAAAE,5
        System.out.println("depth = " + depth);
        System.out.println("concat = " + concat);

        System.out.println("index = " + index + ", count = " + count);

        if (depth > 5) {
            return;
        }
        for (int i = 0; i < values.length; i++) {
            if (parts[index].equals(values[i])) {
                if (index <= 3) {
                    index++;
                }
            }
            if (word.equals(concat)) {
                return;
            }
            count++;
            bfs(depth + 1, concat.concat(values[i]), word);
        }
    }
}
/**
 * 1. 문자 나누기
 * 2.
 */
