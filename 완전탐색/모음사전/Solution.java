class Solution {
    String[] values = {"A", "E", "I", "O", "U"};
    int count = 0;
    boolean flag;

    public int solution(String word) {
        System.out.println("word = " + word);
        dfs("", word);
        return count;
    }

    private void dfs(String current, String target) {
        System.out.println("current = " + current);
        if (current.length() > 5 || flag) {
            return;
        }
        if (current.equals(target)) {
            flag = true;
            return;
        }
        count++;

        for (String value : values) {
            dfs(current + value, target);
        }
    }
}