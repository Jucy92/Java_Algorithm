import java.util.LinkedList;
import java.util.Queue;

class SolutionV2 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();
        for (String tree : skill_trees) {
            for (char c : skill.toCharArray()) {
                queue.offer(c);
            }

            boolean valid = true;
            for (char c : tree.toCharArray()) {
                if (!queue.contains(c)) {
                    continue;
                }

                if (queue.peek() == c) {
                    queue.poll();
                } else {
                    valid = false;
                    break;
                }
            }

            if (valid) answer++;

        }
        return answer;
    }
}