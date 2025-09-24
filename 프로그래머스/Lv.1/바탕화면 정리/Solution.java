import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        /**
         * i, j 모든 좌표 확인하면서
         * 가장 작은 j값이 y 좌표 가장 작은 i 값이 x좌표 (lu)
         * 가장 큰 j값이 y 좌표 가장 큰 i 값이 x좌표 (rd)
         * 파일은 격자게 담겨있기 때문에 마지막 좌표에서 x+1, y+1 해줘야함
         * 파일은 격자칸에 있지만, 드래그는 격자점을 기준
         */
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char currentChar = wallpaper[i].charAt(j);
                if (currentChar == '#') {
                    if (lux > i) lux = i;
                    if (luy > j) luy = j;
                    if (rdx < i) rdx = i;
                    if (rdy < j) rdy = j;
                }
            }

        }
        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}