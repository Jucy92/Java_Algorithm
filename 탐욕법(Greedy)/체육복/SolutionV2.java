class SolutionV2 {  //
    /**
     * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
     * 위 조건에 대한 처리가 안되어 있음 => 제한사항을 놓침
     * 또한 L*R로 최악의 경우 O(n^2) 시간 복잡도 발생  
     */
    private boolean[] checked;
    private int count=0;
    public int solution(int n, int[] lost, int[] reserve) { // 5, {2,4}, {1,3,5} -> 5

        this.checked = new boolean[n + 1]; // 인덱스 크기 말고 숫자 그대로 인덱스화 -> 1부터 시작하는거처럼
        count = n - lost.length;
        for (int i : lost) {
            dfs(i, reserve);
        }
        return count;
    }

    private void dfs(int target, int[] reserve) {
        boolean flag = false;
        for (int helper : reserve) {
            if (flag) {
                break;
            }
            if (!checked[helper]) {
                if ((helper > 1) && (helper - 1 == target)) {
                    flag = true;
                    checked[helper] = true;
                    count++;
                } else if (helper + 1 == target) {
                    flag = true;
                    checked[helper] = true;
                    count++;
                }
            }
        }
    }
}