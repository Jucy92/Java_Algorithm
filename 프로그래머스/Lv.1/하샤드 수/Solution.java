class Solution {
    public boolean solution(int x) {
        int digitSum = String.valueOf(x)
                .chars()
                .map(c -> c - '0')
                .sum();
        return x % digitSum == 0;
    }
}