class Solution {
    public long solution(int r1, int r2) {
        long count = 0;

        // 1사분면 (x > 0, y > 0)만 계산
        for (int x = 1; x <= r2; x++) {
            // y의 최댓값: x² + y² ≤ r2²
            long maxY = (long) Math.floor(Math.sqrt((long) r2 * r2 - (long) x * x));

            // y의 최솟값: x² + y² ≥ r1²
            long minY;
            if (x < r1) {
                // 작은 원 안쪽에 있으면 최소 y 계산
                minY = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));
            } else {
                // 작은 원 바깥쪽이면 y는 1부터 시작 (y > 0)
                minY = 1;
            }

            if (maxY >= minY) {
                count += (maxY - minY + 1);
            }
        }

        // 1사분면 결과를 4배 (4개 사분면 모두)
        count *= 4;

        // x축 위의 점들 (y = 0, x ≠ 0)
        // r1 ≤ |x| ≤ r2 → 양수와 음수 각각 (r2 - r1 + 1)개
        count += 2L * (r2 - r1 + 1);

        // y축 위의 점들 (x = 0, y ≠ 0)
        // r1 ≤ |y| ≤ r2 → 양수와 음수 각각 (r2 - r1 + 1)개
        count += 2L * (r2 - r1 + 1);

        return count;
    }
}