import java.util.*;
import java.util.stream.LongStream;

class Solution {
    public long[] solution(int x, int n) {
        return LongStream.rangeClosed(1, n)
                .map(i -> (long)  x * i)
                .toArray();

    }

}