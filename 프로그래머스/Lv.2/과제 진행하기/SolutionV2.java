import java.util.*;

class SolutionV2 {
    public String[] solution(String[][] plans) {
        // 1. 시작 시간 기준으로 정렬
        Arrays.sort(plans, (a, b) -> timeToMinute(a[1]) - timeToMinute(b[1]));

        List<String> answer = new ArrayList<>();
        Stack<Task> pausedStack = new Stack<>();

        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int startTime = timeToMinute(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);

            // 다음 과제가 있는 경우
            if (i < plans.length - 1) {
                int nextStartTime = timeToMinute(plans[i + 1][1]);
                int availableTime = nextStartTime - startTime;

                if (playTime <= availableTime) {
                    // 현재 과제 완료 가능
                    answer.add(name);
                    int remainTime = availableTime - playTime;

                    // 남은 시간 동안 멈춰둔 과제들 처리
                    while (!pausedStack.isEmpty() && remainTime > 0) {
                        Task pausedTask = pausedStack.pop();

                        if (pausedTask.remainTime <= remainTime) {
                            // 멈춰둔 과제 완료
                            answer.add(pausedTask.name);
                            remainTime -= pausedTask.remainTime;
                        } else {
                            // 멈춰둔 과제도 완료 못함
                            pausedTask.remainTime -= remainTime;
                            pausedStack.push(pausedTask);
                            break;
                        }
                    }
                } else {
                    // 현재 과제 완료 못함 - 스택에 저장
                    pausedStack.push(new Task(name, playTime - availableTime));
                }
            } else {
                // 마지막 과제는 무조건 완료
                answer.add(name);
            }
        }

        // 스택에 남은 과제들 처리 (최근에 멈춘 것부터)
        while (!pausedStack.isEmpty()) {
            answer.add(pausedStack.pop().name);
        }

        return answer.toArray(new String[0]);
    }

    // "HH:MM" -> 분 단위로 변환
    private int timeToMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 멀춰둔 과제 정보를 저장할 클래스
    static class Task {
        String name;
        int remainTime;

        Task(String name, int remainTime) {
            this.name = name;
            this.remainTime = remainTime;
        }
    }
}
