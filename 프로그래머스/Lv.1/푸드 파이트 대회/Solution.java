import java.util.*;

class Solution {
    public String solution(int[] food) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int half = food[i] / 2;

            for (int j = 0; j < half; j++) {
                sb.append(i);
            }
        }
        int sbLength = sb.length();
        sb.append(0);

        for (int i = sbLength-1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }
}