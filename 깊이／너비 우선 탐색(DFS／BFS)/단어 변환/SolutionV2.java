import java.util.LinkedList;
import java.util.Queue;

class SolutionV2 {
    boolean[] visited;
    int minCount = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) { // DFS
        this.visited = new boolean[words.length];

        // target이 words에 있는지 확인
        boolean targetExists = false;
        for (String word : words) {
            if (word.equals(target)) {
                targetExists = true;
                break;
            }
        }
        if (!targetExists) return 0;

        dfs(begin, target, words, 0);

        return minCount;
    }

    private void dfs(String begin, String target, String[] words, int count) {
        int wordChangeValid = begin.length() - 1;

        if (target.equals(begin)) {
            minCount = Math.min(minCount, count);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int sameCount = 0;
                // 알파벳 하나만 바꿀 수 있다 -> 단어 길이는 다 같다
                for (int j = 0; j < begin.length(); j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        sameCount++;
                    }
                }
                if (wordChangeValid == sameCount) { // 그 단어는 변경이 가능한 상태
                    visited[i] = true;
                    dfs(words[i], target, words, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}