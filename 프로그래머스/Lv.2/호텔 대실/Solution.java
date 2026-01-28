import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 시간을 분으로 변환
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = timeToMinute(book_time[i][0]);
            times[i][1] = timeToMinute(book_time[i][1]);
        }

        // 시작 시간 기준으로 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // 각 객실의 종료 시간을 관리하는 우선순위 큐 (최소 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] time : times) {
            int start = time[0];
            int end = time[1];

            // 가장 빨리 끝나는 객실이 청소 완료된 경우 (종료시간 + 10분 <= 시작시간)
            if (!pq.isEmpty() && pq.peek() + 10 <= start) {
                pq.poll(); // 해당 객실 재사용
            }

            pq.offer(end); // 현재 예약의 종료 시간 추가
        }

        return pq.size(); // 필요한 최소 객실 수
    }

    private int timeToMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}