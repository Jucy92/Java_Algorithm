class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 종료 시간까지의 알람 횟수 - 시작 시간 전까지의 알람 횟수 + 시작 시간 알람 여부
        return count(h2, m2, s2) - count(h1, m1, s1) + (check(h1, m1, s1) ? 1 : 0);
    }

    /**
     * 0시 0분 0초부터 주어진 시간까지(포함) 알람이 울린 횟수 계산
     */
    private int count(int h, int m, int s) {
        long t = (long)h * 3600 + m * 60 + s;  // 초 단위로 변환

        // 초침과 분침이 겹치는 횟수
        // k * 3600/59 <= t 를 만족하는 k(0부터)의 개수
        int minuteAlarms = (int)(t * 59 / 3600) + 1;

        // 초침과 시침이 겹치는 횟수
        // k * 43200/719 <= t 를 만족하는 k(0부터)의 개수
        int hourAlarms = (int)(t * 719 / 43200) + 1;

        int total = minuteAlarms + hourAlarms;

        // 0시 정각과 12시 정각에는 세 바늘이 모두 겹치므로 중복 제거
        int overlap = 1;  // 0시 정각 중복 제거
        if (t >= 43200) {  // 12시간 이상이면
            overlap++;  // 12시 정각 중복 제거
        }

        return total - overlap;
    }

    /**
     * 특정 시간에 알람이 울리는지 확인
     */
    private boolean check(int h, int m, int s) {
        return (m == 0 && s == 0);  // 시작 시간의 값을 확인 (count2-count1 하면서 시작점 제거함)

        /**
        // 0시 또는 12시 정각
        if ((h == 0 || h == 12) && m == 0 && s == 0) {
            return true;
        }

        // 각 바늘의 각도 계산 (도 단위)
        double secondAngle = s * 6.0;  // 초침: 6도/초
        double minuteAngle = (m * 60 + s) * 0.1;  // 분침: 0.1도/초
        double hourAngle = ((h % 12) * 3600 + m * 60 + s) / 120.0;  // 시침: 1/120도/초

        // 초침이 분침 또는 시침과 겹치는지 확인 (오차 범위 고려)
        boolean matchesMinute = Math.abs(secondAngle - minuteAngle) < 0.01;
        boolean matchesHour = Math.abs(secondAngle - hourAngle) < 0.01;

        return matchesMinute || matchesHour;
         */
    }
}