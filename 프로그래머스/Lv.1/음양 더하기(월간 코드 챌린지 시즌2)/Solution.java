class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            sum += (signs[i]) ? absolutes[i] : -absolutes[i];
            /*  // 두 방식 다 동일한 바이크 코드 및 조건 분기 방식으로  성능차이는 느낄 수 없을 정도의 차이
            if (signs[i]) {
                sum += absolutes[i];
            } else {
                sum -= absolutes[i];
            }
            */
        }
        return sum;
    }
}