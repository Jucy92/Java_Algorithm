import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionV2 {  // 할인율 40,40,40,40 고정하고 로직 확인

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[]{0,0};
        int[] discountPercent = {40, 30, 20, 10};   // 24가지 경우의수..? 4.4.4.4 ~ 1.1.1.1
        int[] discountEmoticon = new int[emoticons.length]; // 할인된 금액
        List<int[]> disEmoList = new ArrayList<>();



        for (int i = 0; i < users.length; i++) {
            int percent = users[i][0];
            int money = users[i][1];

            for (int j = 0; j < emoticons.length; j++) {
                discountEmoticon[j] = emoticons[j] * (100 - discountPercent[0]) / 100;
            }
            int sum = 0;
            for (int j = 0; j < discountEmoticon.length; j++) {
                if (percent <= discountPercent[0]) {    // 이모티콘 별 퍼센테지를 따로 가져와야함
                    sum += discountEmoticon[j];
                }
            }
            if (sum >= money) {
                answer[0]++;
            } else {
                answer[1] += sum;
            }
            System.out.println(Arrays.toString(answer));
        }
        return answer;
    }
}
