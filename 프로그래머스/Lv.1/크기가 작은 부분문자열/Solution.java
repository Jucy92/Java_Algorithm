import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long target = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {

            /*   sb 를 계속 선언하고 써야하므로 메모리 누수(
            StringBuilder currentString = new StringBuilder();
            for (int j = i; j < i+p.length(); j++) {
                currentString.append(t.charAt(j));
            }
            String substring = currentString.toString();
            */
            String substring = t.substring(i, i + p.length());
            long current = Long.parseLong(substring);

            if (current <= target) {
                answer++;
            }
        }
        return answer;
    }
}