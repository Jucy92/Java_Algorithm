import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int x = 0; x < commands.length; x++) { // 2차원배열 길이만큼
            int[] command = commands[x];
            int i = command[0] - 1; // Array 배열을 통해 사용 할 시작 인덱스 값
            int j = command[1];     // Array 배열을 통해 사용 할 마지막 인덱스 값
            int k = command[2] - 1; // 꺼낼 인덱스 값

            int[] subArray = Arrays.copyOfRange(array, i, j);   // 배열 자르기 j=마지막 인덱스 전까지만 처리
            Arrays.sort(subArray);    // 배열 정렬

            answer[x]= subArray[k];   // 작업하고 나온 값을 넣어주면 된다.
        }

        return answer;
    }
}