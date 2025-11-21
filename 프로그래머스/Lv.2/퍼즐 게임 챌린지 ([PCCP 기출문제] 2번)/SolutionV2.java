class SolutionV2 {
    public int solution(int[] diffs, int[] times, long limit) {     // 로직은 맞는데 숫자가 커지면 1부터 시작하기 때문에 시간초과 발생
        int level = 1;
        while (true) {

            long chance = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (level >= diffs[i]) {
                    chance += times[i];
                } else {
                    int tryC = diffs[i] - level;
                    chance += (long)(times[i] + times[i - 1]) * tryC + times[i];
                }
            }
            if (chance <= limit) {
                break;
            }
            level++;
        }
        return level;
    }
}