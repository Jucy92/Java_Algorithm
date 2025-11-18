class Solution {
    public int solution(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) { // 완전제곱인 경우
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;

    }


}