class Solution {
    public int solution(int num) {
        int answer = 0;
        int loopCount = 500;
        long collatzNum = num;

        while (answer <= loopCount) {
            if (collatzNum == 1) return answer;
            if (collatzNum % 2 == 0) {
                collatzNum /= 2;
                answer++;
            } else {
                collatzNum = collatzNum * 3 + 1;
                answer++;
            }

        }
        return -1;
    }
}