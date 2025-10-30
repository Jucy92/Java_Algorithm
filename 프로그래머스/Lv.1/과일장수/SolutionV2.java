import java.util.*;

class SolutionV2 {  // 꾸역꾸역 그냥 돌아가게 만듬
    public int solution(int k, int m, int[] score) throws InterruptedException {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int count=0;
        List<Integer> box = new ArrayList<>();
        for (int grade : score) {
            pq.add(grade);
        }
        while(!pq.isEmpty()){
            if (box.size() < m) {
                box.add(pq.poll());
            } else {
                Integer boxMin = Collections.min(box);
                answer += boxMin * m;
                box.clear();
            }
        }
        if (box.size() == m) {
            Integer boxMin = Collections.min(box);
            answer += boxMin * m;
        }
        return answer;
    }
}