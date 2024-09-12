import java.util.ArrayList;
import java.util.List;

public class SolutionV3 {
    public int[] solution(int[] arr) {      // 리스트로 처리할 경우 (셋은 순서보장이 안돼서 패스)
        // 결과를 저장할 리스트
        List<Integer> resultList = new ArrayList<>();

        // 배열의 첫 번째 요소를 결과 리스트에 추가
        resultList.add(arr[0]);

        // 배열을 순차적으로 순회하면서 연속된 숫자가 아니면 리스트에 추가
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                resultList.add(arr[i]);
            }
        }

        // 리스트를 배열로 변환하여 반환
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}