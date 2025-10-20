import java.util.*;

class SolutionV2 {      // 조건문 최소화하기.. 다 넣고 그냥 k보다 클 때 빼면 되는데.. V1는 너무 복잡하게 생각했음..
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            pq.offer(score[i]);

            if (pq.size() > k) {
                pq.poll();
            }

            answer[i] = pq.peek();
        }


        return answer;
    }
}