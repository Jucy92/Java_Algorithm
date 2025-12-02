class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 현재 왼손과 오른손의 위치 (초기: 왼손은 *, 오른손은 #)
        int[] leftPos = {3, 0};  // * 위치
        int[] rightPos = {3, 2}; // # 위치

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                // 왼쪽 열: 왼손 사용
                answer.append("L");
                leftPos = getPosition(number);
            } else if (number == 3 || number == 6 || number == 9) {
                // 오른쪽 열: 오른손 사용
                answer.append("R");
                rightPos = getPosition(number);
            } else {
                // 가운데 열 (2, 5, 8, 0): 거리 비교
                int[] targetPos = getPosition(number);
                int leftDist = getDistance(leftPos, targetPos);
                int rightDist = getDistance(rightPos, targetPos);

                if (leftDist < rightDist) {
                    answer.append("L");
                    leftPos = targetPos;
                } else if (leftDist > rightDist) {
                    answer.append("R");
                    rightPos = targetPos;
                } else {
                    // 거리가 같으면 hand에 따라
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = targetPos;
                    } else {
                        answer.append("R");
                        rightPos = targetPos;
                    }
                }
            }
        }

        return answer.toString();
    }

    // 숫자의 키패드 좌표를 반환
    private int[] getPosition(int number) {
        if (number == 0) return new int[]{3, 1};

        int row = (number - 1) / 3;
        int col = (number - 1) % 3;
        return new int[]{row, col};
    }

    // 맨해튼 거리 계산
    private int getDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}