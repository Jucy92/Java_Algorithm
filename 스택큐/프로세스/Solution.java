import java.util.*;

public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(priorities[i], i)); // 각 번호별 location 저장
        }

        while (!queue.isEmpty()) {
            // 일단 큐는 값을 비교해서 제일 큰 값이 우선적으로 나가게해야함
            Process current = queue.poll();
            boolean hasHigherPriority = queue.stream().anyMatch(p-> p.priority > current.priority); // 방금 꺼낸 값이랑 큐에 있는 값이랑 비교해서 큐에 있는 값이 크면 true 작거나 같으면 false

            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                answer++;
                if (current.location == location) { // 해당 location 번호가 맞는지 체크하고 맞으면 값 리턴
                    return answer;
                }
            }
        }
        return -1;  // 비정상 종료(이론상 도달하지 않음)
    }

    public class Process {
        int priority;
        int location;

        public Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

    }
}
