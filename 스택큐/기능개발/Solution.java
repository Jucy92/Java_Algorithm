import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> daysQue = new ArrayDeque<>();        // 작업이 필요한 일수 저장
        List<Integer> result = new ArrayList<>();           // 결과 값 저장

        // progresses = {93, 30, 55}        speeds = {1, 30, 5}
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];   // 100 - 작업량 = 남은 작업량
            int day = (int) Math.ceil((double) remain / speeds[i]);   // ceil 올림처리, 작업량/작업시간 = 작업에 걸리는 시간(일)
            daysQue.offer(day);              // 작업에 소요되는 시간(일)
        }

        while (!daysQue.isEmpty()) {                // 큐가 비어 있지 않으면 반복
            Integer deployDay = daysQue.poll();     // 기준 배포 일
            int count = 1;                          // 배포된 작업 수 기본으로 1개
            while (!daysQue.isEmpty() && (daysQue.peek() <= deployDay)) {   // 큐가 비어있지 않고, peek의 값이 기준 배포일보다 작거나 같을 때 반복
                daysQue.poll();     // 기준 배포일보다 작거나 같기 때문에, 기준 배포일에 같이 배포 가능
                count++;            // 배포되는 작업 추가
            }
            result.add(count);
        }

        return result.stream().mapToInt(i->i).toArray();
        //return result;    // 타입이 List 일 경우 가능
    }
}