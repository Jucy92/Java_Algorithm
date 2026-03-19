import java.util.Arrays;

class SolutionV2 {  // 최종적으로 K개를 구할 때 필요한 X의 값이니깐..
    public int solution(int N, int K, String[] bid) {
        int answer = 0;
        int[] d = new int[N];

        for (int i = 0; i< N; i++) {
            String[] parts = bid[i].split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            d[i] = b-a;
        }
        Arrays.sort(d);// 오름차순 정렬
        // d[0]이 가장 작은 값 = 가장 쉽게 낙찰받는 지면
        // K개를 낙찰받으려면 K번째로 작은 D값 이상이면 됨

        return Math.max(0,d[K-1]);  // 다만, 모든 입찰에 대해서 초기 입찰로 낙찰 받는 경우가 있어 최소 0으로 양수 처리
    }
}
