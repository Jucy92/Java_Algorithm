class Solution {
    public long solution(int price, int money, int count) {
        // 등차수열의 합 공식 사용: n(n+1)/2
        long totalCost = (long) price * count * (count + 1) / 2;

        // 부족한 금액 계산 (부족하지 않으면 0)
        long shortage = totalCost - money;
        return shortage > 0 ? shortage : 0;
    }
}