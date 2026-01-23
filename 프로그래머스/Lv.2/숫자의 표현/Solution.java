class Solution {
    public int solution(int n) {
        int right = 1, left = 1, sum = 1;
        int answer = 0;

        while (left <= n) {
            if (sum < n) {
                right++;
                sum += right;
            } else if (sum == n) {
                answer++;
                sum -= left++;
            } else {
                sum -= left++;
            }
        }
        return answer;
    }
}