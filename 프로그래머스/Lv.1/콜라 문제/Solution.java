class Solution {

    public int solution(int a, int b, int n) {  // 5, 2, 20 => 12
        int count = 0;
        int bottles = n;
        while (a <= bottles) {
            int exchange = bottles / a * b;     // 현재(n) 병으로 반납(a)하고 교환 받은(b) 총 병 = 교환 한 총 병 수
            int remain = bottles % a;           // 교환하지 못한 빈 병
            count += exchange;
            bottles = exchange + remain;        // 가진 병 최신화
        }
        /*
        while (a <= bottles) {
            int exchangeCount = bottles / a;    // 교환 가능 횟수
            int newCola = exchangeCount * b;    // 받는 콜라 수
            count += newCola;                   // 총 콜라 누적
            bottles = bottles % a + newCola;    // 남은 빈병 + 새로 받은 빈병
        }
        */
        return count;
    }

}