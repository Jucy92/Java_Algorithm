import java.util.*;
import java.util.stream.IntStream;

class SolutionV2 {
    public int[] solution(int[] numbers) {
        return IntStream.range(0, numbers.length)
                .flatMap(i -> IntStream.range(i + 1, numbers.length)    // 각 i에 대해 새로운 Stream 생성
                        .map(j -> numbers[i] + numbers[j]))
                .distinct()
                .sorted()
                .toArray();
    }
}