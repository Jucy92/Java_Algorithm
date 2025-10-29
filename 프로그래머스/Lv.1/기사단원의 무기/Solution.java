class Solution {    // 메모리 효율화
    public int solution(int number, int limit, int power) {
        int answer = 0;

        // 1번부터 number번까지 각 기사의 무기 공격력 계산
        for (int i = 1; i <= number; i++) {
            int divisorCount = countDivisors(i);

            // 약수 개수가 limit를 초과하면 power 사용, 아니면 약수 개수 사용
            if (divisorCount > limit) {
                answer += power;
            } else {
                answer += divisorCount;
            }
        }

        return answer;
    }

    // 약수의 개수를 효율적으로 구하는 함수 (O(√n))
    private int countDivisors(int n) {
        int count = 0;

        // 1부터 √n까지만 확인
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; // i는 약수

                // i와 n/i가 다른 경우 (완전제곱수가 아닌 경우)
                if (i * i != n) {
                    count++; // n/i도 약수
                }
            }
        }

        return count;
    }
}