import java.util.ArrayList;
import java.util.List;

class SolutionV2 {
    public int solution(int number, int limit, int power) {
        int total = 0;
        // 약수 = 나누어 떨어지는 수(몫만 있고 나머지가0)
        for (int i = 1; i <= number; i++) {
            int divisorCount = getDivisorCount(i);
            if (divisorCount <= limit) {    // == (divisorCount > limit)
                total += divisorCount;
            } else {
                total += power;
            }

        }
        return total;


    }

    private int getDivisorCount(int number) {
        int count = 0;
        List<Integer> divisorList = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisorList.add(i);
                count++;
            }
        }
//        System.out.println(number +"의 약수는 = " + divisorList);
        return count;
    }
}