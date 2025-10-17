import java.util.*;

class SolutionV2 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (indexMap.containsKey(ch)) {
                answer[i] = i - indexMap.get(ch);
            } else {
                answer[i] = -1;
            }
            indexMap.put(ch, i);

        }

        return answer;
    }
}