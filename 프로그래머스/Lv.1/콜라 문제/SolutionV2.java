import java.util.ArrayList;
import java.util.List;

class SolutionV2 {  // 틀린 케이스..  마지막 문제 하나로 처리 못함

    public int solution(int a, int b, int n) {  // 5, 2, 20 => 12
        int count = 0;
        int current = n;
        List<Integer> replenish = new ArrayList<>();
        while (a <= current) {
            if (current % a != 0) {
                replenish.add(current % a);
            }
            current = current/a * b;
            count += current;
        }
        for (int i = 0; i < replenish.size(); i++) {
            current += replenish.get(i);
            int remain = 0;
            if (current % a != 0) {
                remain = current % a;
            }
            current = current/a * b;
            count += current;
            current += remain;
            // 문제는 여기서 또 나눠진 값에 대한 마지막 처리가 for문 반복 횟수 부족으로 처리안됨..
        }


        return count;
    }

}