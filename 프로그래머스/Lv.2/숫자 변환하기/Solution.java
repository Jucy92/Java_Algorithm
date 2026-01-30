import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] checked = new boolean[y + 1];
        queue.offer(new int[]{x, 0});
        checked[x] = true;

        if (x == y) return 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];

            int[] options = {value + n, value * 2, value * 3};
            for (int option : options) {
                if (option == y) {
                    return count + 1;
                }
                if (option < y && !checked[option]) {
                    queue.offer(new int[]{option, count + 1});
                    checked[option] = true;
                }
            }
        }
        return -1;
    }
}