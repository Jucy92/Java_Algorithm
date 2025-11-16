class SolutionV2 {
    public long solution(int price, int money, int count) {
        long charge = 0;
        for (int i = 1; i <= count; i++) {
            charge += (long) price * i;
        }
        if (money - charge < 0) {
            return Math.abs(money - charge);
        }
        return 0;
    }
}