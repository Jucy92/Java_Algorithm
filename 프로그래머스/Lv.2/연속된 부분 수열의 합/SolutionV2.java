import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionV2 {  // 시간 초과로 테스트 통과 실패


    public int[] solution(int[] sequence, int k) {
        List<int[]> arrayList = new ArrayList<>();
        int[] answer = {};

        for (int i = 0; i < sequence.length; i++) {
            int sum = 0;
            List<Integer> indexList = new ArrayList<>();
            for (int j = i; j < sequence.length; j++) {
                sum += sequence[j];
                indexList.add(j);
                if (k <= sum) {
                    if (k == sum) {
                        arrayList.add(indexList.stream().mapToInt(Integer::intValue).toArray());
                    }
                    break;
                }
            }
        }
//        arrayList.stream().map(arrayList::get).min();
        int minSize = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int[] ints : arrayList) {
            System.out.println("ints = " + Arrays.toString(ints));
        }
        for (int i = 0; i < arrayList.size(); i++) {
            //minSize = Math.min(minSize, arrayList.get(i).length);
            if (arrayList.get(i).length < minSize) {
                minSize = arrayList.get(i).length;
                minIndex = i;
            }
        }

        int[] result = arrayList.get(minIndex);
        if (result.length < 2) {
            return new int[]{result[0], result[0]};
        } else {
            return new int[]{result[0], result[result.length - 1]};
        }
//        return result;
    }

}