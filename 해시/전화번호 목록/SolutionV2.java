import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionV2 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);    // 배열 정렬 => 2중 루프를 1중 루프로 처리,

        for (int i = 0; i < phone_book.length-1; i++) { // length-1한 이유는.. 인접한 것 하나만 확인하면 되기 때문.. V1이 정상 체크
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}


