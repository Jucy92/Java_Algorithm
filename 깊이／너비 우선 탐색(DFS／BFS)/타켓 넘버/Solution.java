import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] numbers, int target) { //[1, 1, 1, 1, 1] -> 5
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // 초기 합계 0부터 시작

        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();
            //System.out.println(i + "번 째, queue 사이즈=" + size + ", queue="+queue);
            for (int j = 0; j < size; j++) {
                Integer current = queue.poll();

                queue.offer(current + numbers[i]);  // size만큼 지난 후 + 했을 때 모든 경우의 값

                queue.offer(current - numbers[i]);  // size만큼 지난 후 - 했을 때 모든 경우의 값
                //System.out.println("queue = " + queue);

            }
            //System.out.println("");
        }
        int count = 0;
        while (!queue.isEmpty()) {  // 그리고 큐에서 뺴면서 target 값과 같은 경우 count 증가
            if (queue.poll() == target) {
                count++;
            }
        }
        return count;
    }


}