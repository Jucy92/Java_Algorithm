class Solution {
    public int solution(int n) {
        // 2부터 시작해서 n을 x로 나눈 나머지가 1인 첫 번째 x를 찾음
        for (int x = 2; x < n; x++) {
            if (n % x == 1) {
                return x;
            }
        }
        return n - 1; // 최악의 경우 (도달하지 않음)
    }
}