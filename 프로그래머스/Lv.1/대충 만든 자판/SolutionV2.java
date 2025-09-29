import java.util.*;

class SolutionV2 {  // 비효율적
    public int[] solution(String[] keymap, String[] targets) {
        /**
         * keymap.length 개의 자판이 있다, keymap[0]의 자판순서는 keymap[0].length() 순서로 움직인다
         * 타켓을 찾기 위해 최소한의 숫자로 클릭
         */
        int n = targets.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            int size = targets[i].length();

            int totalClick = 0;
            boolean possible = true;
            for (int j = 0; j < size; j++) {    // target 글자만큼 반복
                char character = targets[i].charAt(j);
                String str = String.valueOf(character);
                int minCount = Integer.MAX_VALUE;

                for (String key : keymap) { // target 한 글자에 대해서 최소 클릭 수 찾기
                    int result = loopForSameWord(character, key); // 최악의 방법일까..? => 최악의 방법... 100번째에 데이터가 있다면 100*100*100*100을 해야 확인가능
                    if (minCount > result) minCount = result;
                    /**
                     * targets의 각 문자열 (최대 100개)
                     *   └─ 각 문자 (최대 100개)
                     *       └─ 모든 keymap 순회 (최대 100개)
                     *           └─ 각 keymap 문자열 순회 (최대 100개)
                     */
                }
                if (minCount == Integer.MAX_VALUE) {
                    possible = false;
                    break;  // 중간에 안되는 문자 발견하면 어차피 안되니깐 뒤에꺼 비교 x
                }
                totalClick += minCount;
            }
            answer[i] = possible ? totalClick : -1;
        }


        return answer;
    }

    private int loopForSameWord(char target, String compareWord) {
        for (int i = 0; i < compareWord.length(); i++) {
            if (target == compareWord.charAt(i)) {
                return i + 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}