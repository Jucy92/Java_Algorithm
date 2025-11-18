class Solution {
    public int solution(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) { // 완전제곱인 경우 반환 받은 값으로 그대로 곱하면 원래 숫자가 나옴 , 본인과 떨어지는 값이 있기 때문에 홀수
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;

    }


}