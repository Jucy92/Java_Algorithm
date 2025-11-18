class SolutionV2 {
    public int solution(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            /*
            int count = countDivisors(i);
            if (count % 2 == 0) {
                sum += i;
            } else {
                sum -= i;
            }
            */
            sum += (countDivisors(i) % 2 == 0) ? i : -i;
        }
        return sum;

    }

    private int countDivisors(int num) {
        int count = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;

                if (i * i != num) { // 예를 16으로 4*4 == 16 이니깐 떨어지니깐 위에서 한번만 더하는건 OK
                    count++;        // 예가 14일 때 i = 1,2 밖에안돼 -> 이때 더해지는게 이해가안됨.. 숫자를 구하는게 아니라 방식을 구하는건가 -> i(1)로 떨어지지 않았다는건 반대에 무언가 있다는건가
                }                   // => 위 두개 고민이 맞음

            }
        }
        return count;
    }
}