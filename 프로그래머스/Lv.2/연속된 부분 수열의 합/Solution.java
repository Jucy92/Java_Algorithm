class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0;
        int right = 0;
        int sum = sequence[0];

        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < n) {
            if (sum == k) {
                // 합이 k인 경우 - 길이 비교 후 업데이트
                int length = right - left + 1;
                if (length < minLength) {
                    minLength = length;
                    answer[0] = left;
                    answer[1] = right;
                }
                // 다음 경우를 찾기 위해 left 이동
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                // 합이 작으면 right를 증가시켜 구간 확장
                right++;
                if (right < n) {
                    sum += sequence[right];
                } else {
                    break;
                }
            } else {
                // 합이 크면 left를 증가시켜 구간 축소
                sum -= sequence[left];
                left++;
            }
        }

        return answer;
    }
}