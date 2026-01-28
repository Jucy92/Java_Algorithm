import java.util.Arrays;
import java.util.PriorityQueue;

class SolutionV2 {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] timeToMinute = new int[n][2];
        for (int i = 0; i< n; i++) {
            String[] inParts = book_time[i][0].split(":");
            int checkIn = Integer.parseInt(inParts[0]) * 60 + Integer.parseInt(inParts[1]);

            String[] outParts = book_time[i][1].split(":");
            int checkOut = Integer.parseInt(outParts[0]) * 60 + Integer.parseInt(outParts[1]);

            timeToMinute[i][0] = checkIn;
            timeToMinute[i][1] = checkOut;
        }
        Arrays.sort(timeToMinute, (start, end) -> start[0] - end[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] time : timeToMinute) {
            int start = time[0];
            int end = time[1];

            if (!queue.isEmpty() && queue.peek() + 10 <= start) {
                queue.poll();
            }
            queue.offer(end);
        }
        return queue.size();
    }
}