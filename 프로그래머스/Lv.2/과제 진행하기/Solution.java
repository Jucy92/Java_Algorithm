import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        // 시간 기준 정렬
        Arrays.sort(plans, (a, b) -> timeToMinute(a[1]) - timeToMinute(b[1]));
        String[] answer = new String[plans.length];
        int idx = 0;
        Stack<Task> stack = new Stack<>();

        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int startTime = timeToMinute(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            // 다음 값 확인
            if (i < plans.length - 1) {
                int nextStartTime = timeToMinute(plans[i + 1][1]);
                int availableTime = nextStartTime - startTime;

                // 처리해야할 시간이 남아 있는 경우 스택에 추가
                if (playTime <= availableTime ) {
                    answer[idx++] = name;

                    int remainTime = availableTime - playTime;  // (다음시간 - 현재시간) - 현재 처리시간 = 다른 업무 처리할 수 있는 시간(남는시간)
                    while (!stack.isEmpty() && remainTime > 0) {
                        Task current = stack.pop();
                        if (current.remainTime <= remainTime) {
                            answer[idx++] = current.name;
                            remainTime -= current.remainTime;
                        } else {
                            current.remainTime -= remainTime;
                            stack.push(current);
                            break;  // remainTime 시간을 다 사용 했기 때문에 다음 시간대로 이동
                        }
                    }
                } else {
                    // 완료 못 하는 경우 스택에 저장
                    stack.push(new Task(name, playTime - availableTime));
                }
            } else {
                answer[idx++] = name;
            }
        }
        while (!stack.isEmpty()) {
            Task current = stack.pop();
            answer[idx++] = current.name;
        }

        return answer;
    }

    private int timeToMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);

    }

    private class Task {
        String name;
        int remainTime;

        public Task(String name, int remainTime) {
            this.name = name;
            this.remainTime = remainTime;
        }
    }
}