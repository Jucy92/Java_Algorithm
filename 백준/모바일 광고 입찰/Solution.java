import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int N, int K, String[] bid) {
        int answer = 0;
        int x=0;
        int count = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean valid = true;
        for (String s : bid) {
            String[] parts = s.split(" ");
            int myCompany = Integer.parseInt(parts[0]);
            int opponent = Integer.parseInt(parts[1]);

            if (myCompany >= opponent) {
                count++;
            } else {
                queue.offer(opponent-myCompany);
            }
        }

        if (K <= count) return 0;

        for (int i = 0; i < K - count; i++) {
            x = queue.poll();
        }
        answer = x;


        return answer;
    }
}