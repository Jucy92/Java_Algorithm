import java.util.*;

class SolutionV2 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int x = 0; x < commands.length; x++) { // 2차원배열 길이만큼
            int index = 0;
            int i = commands[x][0] - 1; // 시작 인덱스 값
            int j = commands[x][1] - 1; // 마지막 인덱스 값
            int k = commands[x][2] - 1; // 꺼낼 인덱스 값
            int[] subArray = new int[j - i + 1];

            for (int y = i; y <= j; y++) {
                subArray[index++] = array[y];
            }
            Arrays.sort(subArray); // 배열 정렬

            answer[x]= subArray[k];   // 작업하고 나온 값을 넣어주면 된다.
        }

        return answer;
    }
}