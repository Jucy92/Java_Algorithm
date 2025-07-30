public class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int currentTime = parseTimeToSeconds(pos);

        int videoTimeToSecond = parseTimeToSeconds(video_len);
        int opStartToSecond = parseTimeToSeconds(op_start);
        int opEndToSecond = parseTimeToSeconds(op_end);

        for (String command : commands) {
            currentTime = skipOpening(opStartToSecond, currentTime, opEndToSecond);

            currentTime = command.equals("prev") ? Math.max(0, currentTime - 10) : Math.min(videoTimeToSecond, currentTime + 10);

            currentTime = skipOpening(opStartToSecond, currentTime, opEndToSecond);
        }

        /*
        for (int i = 0; i < commands.length; i++) {
            //while(){
            currentTime = skipOpening(opStartToSecond, currentTime, opEndToSecond);
            switch (commands[i]) {
                case "prev":
                    if (currentTime - 10 <= 0) {
                        currentTime = 0;
                    } else {
                        currentTime -= 10;
                    }
                    System.out.println("입력된 명령 :"+ commands[i]+" 현재 시간 :" + currentTime);
                    break;
                case "next":
                    if (videoTimeToSecond <= currentTime + 10) {
                        currentTime = videoTimeToSecond;
                    } else {
                        currentTime += 10;
                    }
                    System.out.println("입력된 명령 :"+ commands[i]+" 현재 시간 :" + currentTime);
                    break;
                default:
                    answer = "잘못된 입력이 들어왔습니다.";
                    break;
            }
        }
        */


        return String.format("%02d:%02d", currentTime / 60, currentTime % 60);
    }

    private static int parseTimeToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static int skipOpening(int opStartToSecond, int currentTime, int opEndToSecond) {
        if (opStartToSecond <= currentTime && currentTime <= opEndToSecond) {   // 오프닝 구간인 경우 자동 스킵
            currentTime = opEndToSecond;
        }
        return currentTime;
    }
    /**
     * 접근 방식
     * 1.  문자열 시간을 받아서 인트형으로 변경 후 처리하고 다시 mm:ss로 리턴
     * :문자 기준으로 분 초 나눠서 저장
     */


}
