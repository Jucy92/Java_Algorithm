class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rankArray = {6, 6, 5, 4, 3, 2, 1};
        int count = 0;
        int zero = 0;
        for (int num : lottos) {
            if (num == 0) {
                zero++;
            } else {
                for (int win_num : win_nums) {
                    if (win_num == num) {
                        count++;
                        break;
                    }
                }
            }
        }
        return new int[]{rankArray[count + zero], rankArray[count]};
//        return  new int[]{getRank(count + zero), getRank(count)}; // 아래 getRank 호출 시 사용
    }
    private int getRank(int matchCount) {
        switch (matchCount) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }

}