class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees) {
            boolean valid = true;
            int index = 0;

            for (int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);
                int pos = skill.indexOf(c);

                if (pos == -1) {
                    continue;
                } else if (pos == index) {
                    index++;
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