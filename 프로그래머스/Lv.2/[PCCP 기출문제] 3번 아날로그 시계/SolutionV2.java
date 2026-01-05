import java.util.Date;

class SolutionV2 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        String standard = h1 + "-" + m1 + "-" + s1;
        String target = h2 + "-" + m2 + "-" + s2;

        System.out.println("standard = " + standard);
        System.out.println("target = " + target);
        int t1 = count(h1, m1, s1);
        int t2 = count(h2, m2, s2);
        int check = check(h1, m1, s1) ? 1 : 0;
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("check = " + check);
        return t2 - t1 + check;
    }

    private int count(int h, int m, int s) {
        // 시간을 초로 변환
        long t = (long) h * 3600 + m * 60 + s;

        int minuteAlarms = (int) (t * 59 / 3600) + 1;

        int hourAlarms = (int) (t * 719 / 43200) + 1;

        int total = minuteAlarms + hourAlarms;

        int overlap = 1; // 0시(자정) 중복 제거
        if (t >= 43200) { // 12시(정오) 정각도 체크
            overlap++;
        }
        return total - overlap;
    }

    private boolean check(int h, int m, int s) {
        if ((h == 0 || h == 12) && m == 0 && s == 0) {
            return true;
        }
        return false;
    }
}