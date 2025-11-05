
class Solution {
    private final static String[] WORDS = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;

        for (String bab : babbling) {
            if (canPronounce(bab)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean canPronounce(String target) {
        int index = 0;
        String prevWord = "";   // 반복된 소리를 막기 위한 체크용

        while (index < target.length()) {
            boolean accessible = false;

            for (String word : WORDS) {
                if (target.startsWith(word, index)) { // 처음에는 0인덱스부터 체크하지만, 하나를 찾으면 그 길이만큼은 건나 뛴 다음 인덱스에서부터 체크
                    // &&로 한줄로 해도 되지만 주석을 위해
                    if (!word.equals(prevWord)) {   // 반복된 소리 처리, 처음엔 빈 문자열 -> 특정 문자열이 연속으로 들어오는 것을 막기 위해
                        prevWord = word;
                        index += word.length();
                        accessible = true;
                        break;
                    }
                }
                
            }
            if (!accessible) {  // 무한루프 방지
                return false;
            }
        }

        return true;
    }
}