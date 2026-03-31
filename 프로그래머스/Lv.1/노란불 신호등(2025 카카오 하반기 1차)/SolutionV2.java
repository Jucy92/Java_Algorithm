class SolutionV2 {      // G, Y, R > 0
    public long gcd(long a, long b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    private boolean isYellow(int t, int[] signal) {
        int G = signal[0];
        int Y = signal[1];
        int R = signal[2];
        int cycle = G + Y + R;
        int pos = (t) % cycle;
        return G + 1 <= pos && pos <= G + Y;
    }

    public long solution(int[][] signals) {
        long limit = 1;
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            limit = lcm(limit, cycle);
        }

        for (long t = 1; t <= limit; t++) {
            boolean allYellow = true;
            for (int[] signal : signals) {
                if (!isYellow((int) t, signal)) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return t;
        }
        return -1;
    }
}