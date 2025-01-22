import java.util.*;

public class Solution {     // 복잡도 - O(n)
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0; // 현재 시각
        int totalTime = 0; // 반환 시간 합산
        int count = 0; // 완료된 작업 수
        int index = 0; // 요청된 작업의 순서 인덱스

        // 작업 요청을 요청 시각 오름차순으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        // 우선순위 큐 (작업 소요시간, 요청 시각 기준)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]); // 소요시간 우선
            return Integer.compare(a[0], b[0]); // 요청시각 차순
        });

        // {{0, 3}, {1, 9}, {3, 5}} // {{0,3}, {5,12}, {5,9}}
        while (count < jobs.length) {
            // 현재 시각에 요청된 작업을 모두 대기 큐에 추가
            while (index < jobs.length && jobs[index][0] <= time) { // time 값으로 확인 후 pq 우선큐에 순차적으로 추가
                pq.offer(jobs[index]);  // 큐에 들어가면서는 소요시간, 요청시각 순으로 오름차순 정렬
                index++;
            }

            // 대기 큐에서 작업 수행
            if (!pq.isEmpty()) {    // 요청시각이 바로 떨어져서 처리되는 경우
                int[] currentJob = pq.poll(); // 우선순위가 가장 높은 작업
                time += currentJob[1]; // 현재 작업 수행 시간만큼 경과
                totalTime += time - currentJob[0]; // 반환 시간 누적
                count++; // 완료된 작업 수 증가
            } else {                // time과 요청시각의 차이가 있는 경우
                // 대기 큐가 비어있으면 다음 요청 시각으로 이동
                time = jobs[index][0];
            }
        }

        answer = totalTime / jobs.length; // 평균 반환 시간의 정수 부분
        return answer;
    }
}