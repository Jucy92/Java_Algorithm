import java.util.*;


public class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        //1. 출근 희망 시각 schedules와  startday일자의 요일에 대해서 timelogs에 시간이 +10까지 안의 범위인지
        /**
         * 놓친 부분
         * 1. 요일 구하는 부분 
         * 2. 시간 변환 부분 855 +10 -> 865 으로 계산되면 오류
         */

        for (int i = 0; i < timelogs.length; i++) {
            int schedule = schedules[i];    // 955  700
            int hour = schedule / 100;      // 9    7
            int minute = schedule % 100;    // 55   0
            int cutTime = (hour * 60) + minute + 10;    // 540 + 65 = 605   420 + 10 = 430

            boolean isEligible = true;

            for (int j = 0; j < timelogs[i].length; j++) {
                // startday로 부터 6,7(토,일)에 해당하는 요일의 시간 체크는 제외
                int day = (startday - 1 + j) % 7 + 1;
                if (day == 6 || day == 7) continue;

                int logSchedule = timelogs[i][j];
                int logHour = logSchedule / 100;
                int logMinute = logSchedule % 100;
                int logTime = logHour * 60 + logMinute;
                if (logTime > cutTime) {
                    isEligible = false;
                    break;
                }
            }
            if (isEligible) {
                answer++;
            }

        }
        return answer;
    }


}
