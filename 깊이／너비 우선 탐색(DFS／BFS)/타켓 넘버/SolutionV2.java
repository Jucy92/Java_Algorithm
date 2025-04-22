class SolutionV2 {
    private int count;
    private int[] numbers;
    public int solution(int[] numbers, int target) { //[1, 1, 1, 1, 1] -> 5
        this.count = 0;
        this.numbers = numbers;
        dfs(target, 0,0);

        return count;
    }

    private void dfs(int target, int index, int total) {
        if (index == numbers.length) {
            if (target == total) {
                count++;
            }
            return;
        }
        dfs(target, index + 1, total + numbers[index]);

        dfs(target, index + 1, total - numbers[index]);
    }
}