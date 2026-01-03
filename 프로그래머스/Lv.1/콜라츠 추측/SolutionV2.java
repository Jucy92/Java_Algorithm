class SolutionV2 {
    public int solution(int num) {
        long n = num;  // 오버플로우 방지
        int count = 0;

        // 이미 1이면 0 반환
        if (n == 1) {
            return 0;
        }

        while (n != 1) {
            // 500번 반복해도 1이 안되면 -1 반환
            if (count >= 500) {
                return -1;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            count++;
        }

        return count;
    }
}