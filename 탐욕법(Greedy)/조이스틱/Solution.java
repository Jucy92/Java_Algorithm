class Solution {
    public int solution(String name) {  // ABAAAB
        int count = 0;
        int length = name.length();
        int minMove = length - 1; // 기본 최소 이동 횟수 (오른쪽으로 쭉 이동)

        for (int i = 0; i < length; i++) {
            // 1. 각 위치 문자별 위아래 변경 값 구하기
            char c = name.charAt(i);
            count += Math.min(c - 'A', 'Z' - c + 1);    // i별 문자별 최소 변경 값 추가 (c +1 해주는 이유는 A->Z로 이동하는데 1회 이동 사용)

            // 2. 위치 별 자리 커서 이동 값 구하기
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            int move1 = i * 2 + (length - next);
            int move2 = (length - next) * 2 + i;
            minMove = Math.min(minMove, move1);
            minMove = Math.min(minMove, move2);
        }
        count += minMove;
        return count;
    }
}