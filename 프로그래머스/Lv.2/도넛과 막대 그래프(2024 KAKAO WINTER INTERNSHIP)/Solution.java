import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[][] edges) {
        /**
         * 도넛 n 정점 n 간선     => 1개 나가고 1개 들어옴
         * 막대 n 정점 n-1 간선   => n-1개 나가고 1개 들어옴
         * 8자 2n+1 정점 2n+2 간선   => 2개가 나가고 2개가 들어옴
         */
        int maxCount = 0;
        //Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
//            if (!edgeMap.containsKey(edges[i][0])){
//                edgeMap.put(edges[i][0], new ArrayList<>());
//            }
//            edgeMap.get(edges[i][0]).add(edges[i][1]);
            maxCount = Math.max(Math.max(maxCount, edges[i][0]),edges[i][1]);
        }
        int[] inDegree = new int[maxCount+1];
        int[] outDegree = new int[maxCount+1];

        for (int i = 0; i < edges.length; i++) {
            outDegree[edges[i][0]]++;
            inDegree[edges[i][1]]++;
        }
//        System.out.println("inDegree = " + Arrays.toString(inDegree));
//        System.out.println("outDegree = " + Arrays.toString(outDegree));
//        System.out.println("edgeMap = " + edgeMap);

        int createdVertex = 0, donut = 0, stick = 0, eight = 0;


        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                createdVertex = i;
            }
            else if (inDegree[i] >= 2 && outDegree[i] == 2) {
                eight++;
            }
            else if (outDegree[i] == 0) {
                stick++;
            }
        }
        int totalGraphs = outDegree[createdVertex]; // 그래프 종류
        donut = totalGraphs - stick - eight;

        return new int[]{createdVertex, donut, stick, eight};
    }
}