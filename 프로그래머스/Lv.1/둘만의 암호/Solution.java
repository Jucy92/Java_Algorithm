import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {

        StringBuilder sb = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        for (char character : s.toCharArray()) {
            int count = 0;
            char current = character;

            while (count < index) {
                current = (char) ((current - 'a' + 1) % 26 + 'a');  // 반복 돌 때마다 문자 하나씩 증가
                //current = (char) ((current + 1) < 122 ? current + 1 : current - 25);

                // skip에 없는 문자만 카운트 -> 그래야 문자가 뒤로 밀리면서 하나씩 넘어가짐
                if (!skipSet.contains(current)) {
                    count++;
                }
            }
            sb.append(current);
        }
        return sb.toString();
    }
}