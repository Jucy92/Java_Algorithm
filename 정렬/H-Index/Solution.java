import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        int n = citations.length;   // 5

        for (int i = 0; i < n; i++) {
            // 0,1,3,5,6    -> 0,1,6,6,7    -> 0, 4, 7, 9, 15로 하면? 4에서 멈추나
            int h = n - i;  // 5 -> 4 -> 3 -> 2 -> 1
            //System.out.println("h = " + h);
            //System.out.println("i = " + i + ", citations["+i+"] = " + citations[i]);
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        return hIndex;
    }
}
/*
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int index = citations[i];
            if (index < n) {
                n--;
            } else {
                return n;
            }
        }
        return 0;
    }
}
*/
