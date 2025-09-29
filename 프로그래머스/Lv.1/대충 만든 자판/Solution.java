import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        /**
         * keymap.length 개의 자판이 있다, keymap[0]의 자판순서는 keymap[0].length() 순서로 움직인다
         * 타켓을 찾기 위해 최소한의 숫자로 클릭 -> map에 값 전처리
         */

        int[] answer = new int[targets.length];
        Map<Character, Integer> minClickMap = new HashMap<>();

        for (String key : keymap) { // 각 문자당 최소 클릭 수 전처리
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                int click = i+1;
                minClickMap.put(ch, Math.min(minClickMap.getOrDefault(ch, Integer.MAX_VALUE), click));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int totalClick = 0;
            boolean possible = true;

            for (int j = 0; j < targets[i].length(); j++) {
                char ch = targets[i].charAt(j);
                if (!minClickMap.containsKey(ch)) {
                    possible = false;
                    break;
                }
                totalClick += minClickMap.get(ch);
            }
            answer[i] = possible ? totalClick : -1;
        }

       return answer;
    }


}