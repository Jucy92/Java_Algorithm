class SolutionV2 {
    private int answer = 0;

    public int solution(int[] number) {
        dfs(number, 0, 0, 0);
        return answer;
    }

    // depth: 현재 선택한 학생 수, start: 탐색 시작 인덱스, sum: 현재까지의 합
    private void dfs(int[] number, int depth, int start, int sum) {
        // 3명을 선택했을 때
        if (depth == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }

        // 학생 선택
        for (int i = start; i < number.length; i++) {
            dfs(number, depth + 1, i + 1, sum + number[i]);
        }
    }
}