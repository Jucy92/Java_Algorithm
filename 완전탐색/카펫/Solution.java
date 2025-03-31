import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow){   // 24, 24
        int total = brown + yellow;
        int[] answer = new int[2];

        // 48 % 3,4,5,6
        for (int h = 3; h <= Math.sqrt(total); h++) {
            if (total % h == 0) {   // 노란색 조건 찾기 위해 아래 조건에 대입
                int w = total / h;
                if ((w - 2) * (h - 2) == yellow) { // 노란색 조건
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        return answer;
    }
}

    /**
     * w * h = brown + yellow
     *
     * (w-2) * (h-2) = yellow   -> 카페트 모양 볼 때 윗줄 아래줄 왼쪽 오른쪽 한줄씩 제거하기 때문에
     * wh = 약수의 쌍(최대가 되어야함
     * w >= h (sqrt(y+b) wh=12 -> h=3.xxx)
     *
     * □ □ □
     * □ ■ □
     * □ □ □
     *
     * □ □ □ □ □    15 - 12:3
     * □ ■ ■ ■ □
     * □ □ □ □ □
     *
     * □ □ □ □ □    20 - 14:6
     * □ ■ ■ ■ □
     * □ ■ ■ ■ □
     * □ □ □ □ □
     *
     *
     * 48 % 16*3 -> 노란색 조건에 부합
     * 12*4 -> 노란색 조건에 부합
     * 8*6 -> 노란색 조건에 합
     *
     *
     */


