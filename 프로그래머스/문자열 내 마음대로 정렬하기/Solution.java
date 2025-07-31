import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);
                if (c1 != c2) {
                    return Character.compare(c1,c2);
                    // return c1 - c2; // 동일하게 동작하지만 이렇게하면 숫자 연산으로 오해할 수 있어서 위에처럼 명시적으로 해주는게 좋다
                }
                return o1.compareTo(o2);
            }
        });


        return strings;
    }
}
