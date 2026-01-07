import java.util.Arrays;

class Solution {    // 그리디 알고리즘 O(n) 미래의 가능성을 두고 현재의 최선의 방법
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastInterceptEnd = 0;

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];
            if (start >= lastInterceptEnd) {
                count++;
                lastInterceptEnd = end;
            }
        }

        return count;
    }
}