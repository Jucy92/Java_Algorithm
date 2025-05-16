import java.util.*;

class Solution {        // DFS
    List<String> answer;
    Map<String, PriorityQueue<String>> graph;

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        graph = new HashMap<>();

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>());
            }
            graph.get(from).add(to);
        }
        System.out.println("graph = " + graph);
        dfs("ICN");

        Collections.reverse(answer);

        return answer.toArray(new String[0]);
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {  // 연결돼서 계속 호출하니깐 마지막에 가면 키 값만 있고 밸류가 없음 AND Queue가 비어있지 않을 때 까지
            System.out.println("destinations = " + destinations);
            dfs(destinations.poll());
        }
        System.out.println("destinations = " + destinations);
        answer.add(airport);
    }

}