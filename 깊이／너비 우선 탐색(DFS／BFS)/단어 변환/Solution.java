import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(String begin, String target, String[] words) { // BFS
        boolean targetExists = false;
        for (String word : words) {
            if (target.equals(word)) {
                targetExists = true;
                break;
            }
        }
        if (!targetExists) return 0;

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.word.equals(target)) {
                return current.count;
            }

            for (int i = 0; i < words.length; i++) {
                if (canConvert(current.word, words[i]) && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.count + 1));
                }

            }
        }
        return 0;
    }

    private boolean canConvert(String begin, String word) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }


    private class Node {
        String word;
        int count;
        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}