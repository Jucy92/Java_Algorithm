import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int index = 0;
        while (index < s.length()) {
            char x = s.charAt(index);
            int xCount = 0;
            int xOther = 0;
            int currentIndex = index;

            while (currentIndex < s.length()) {
                if (s.charAt(currentIndex) == x) {
                    xCount++;
                } else {
                    xOther++;
                }

                currentIndex++;

                if (xCount == xOther) {
                    break;
                }
            }
            index = currentIndex;
            count++;
        }
        return count;
    }

}