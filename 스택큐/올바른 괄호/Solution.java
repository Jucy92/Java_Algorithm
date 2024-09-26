import java.util.*;

public class Solution {
    boolean solution(String s) {        // 큐 사용해서 - 최초 생각
        Queue<String> checkQue = new ArrayDeque<>();
        boolean answer = true;
        int lCount = 0, rCount = 0;

        // 1. 입력 받은 s 자에 대해서 조각 조각 분리해야함 => 조각을 큐에 담음
        String[] splitStr = s.split("");
        for (int i = 0; i < splitStr.length; i++) {
            checkQue.offer(splitStr[i]);
        }
        // 2. 조각에 대해서 뺴면서 ") 시작"이거나, "() 개수"가 맞지 않으면 false 리턴
        while (!checkQue.isEmpty()) {
            /*
            if (checkQue.peek() == ")") {
                return false;
            }
            */
            if (checkQue.poll().equals("(")) {
                lCount++;
                //System.out.println("lCount = " + lCount);
            } else {
                rCount++;
                //System.out.println("rCount = " + rCount);
            }
            if (lCount == 0 && rCount > lCount) {
                return false;
            }
        }
        if (lCount == rCount) {
            return true;
        }
        return false;
    }
}