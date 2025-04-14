import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) { // 5, {2,4}, {1,3,5} -> 5
        int[] students = new int[n + 2];    //  0보다 작은 경우와 인덱스 크기보다 큰 경우 예외 발생 방지하기 위해 n+2
        int count = 0;
        Arrays.fill(students, 1);   // 배열 1로 초기화
        
        for (int l : lost) {
            students[l]--;
        }

        for (int r : reserve) {
            students[r]++;
        }
        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                if (students[i - 1] == 2) {
                    students[i]++;
                    students[i - 1]--;
                } else if (students[i + 1] == 2) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1) {
                count++;
            }
        }
        return count;
    }

}