import java.util.*;

class SolutionV2 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> cardQueue1 = new LinkedList<>();
        Queue<String> cardQueue2 = new LinkedList<>();

        for (String str : cards1) {
            cardQueue1.offer(str);
        }
        for (String str : cards2) {
            cardQueue2.offer(str);
        }

        for (String str : goal) {
            if (str.equals(cardQueue1.peek())) {
                cardQueue1.poll();
            } else if (str.equals(cardQueue2.peek())) {
                cardQueue2.poll();
            } else {    // 두개의 카드더미에 없을 경우
                return "No";
            }
        }
        return "Yes";
    }


}