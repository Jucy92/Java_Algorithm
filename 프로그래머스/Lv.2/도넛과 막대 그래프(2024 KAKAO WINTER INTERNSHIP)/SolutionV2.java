class SolutionV2 {
    public int[] solution(int[][] edges) {
        int[] inDegree = new int[1_000_001];
        int[] outDegree = new int[1_000_001];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            outDegree[from]++;
            inDegree[to]++;
        }

        int createdVertex = 0;
        int donut = 0, stick = 0, eight = 0;

        for (int i = 1; i <= 1000000; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                createdVertex = i;
            }
            else if (inDegree[i] >= 2 && outDegree[i] == 2) {
                eight++;
            }
            else if (inDegree[i] > 0 && outDegree[i] == 0) {
                stick++;
            }
        }

        donut = outDegree[createdVertex] - stick - eight;

        return new int[]{createdVertex, donut, stick, eight};
    }

}