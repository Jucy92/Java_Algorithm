import java.util.*;

public class Solution {     // 복잡도 -
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> underScoville = new PriorityQueue<Integer>();

        // 스코빌 지수 추가
        for (int s : scoville) {
            underScoville.offer(s);
        }

        // 힙의 가장 작은 값이 K 이상이 될 때까지 반복
        while (underScoville.size() > 1 && underScoville.peek() < K) {
            Integer firstMin = underScoville.poll();
            Integer secondMin = underScoville.poll();

            underScoville.offer(firstMin + (secondMin*2));
            answer++;
        }

        // 모든 작업이 끝난 후에도 K보다 작은 값이 있다면 -1
        if (underScoville.peek() < K) {
            return -1;
        }

        return answer;
    }


}
