import java.util.*;

class SolutionV2 {

    public String solution(int[] food) {

        StringBuilder left = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int half = food[i] / 2;

            for (int j = 0; j < half; j++) {
                left.append(i);
            }
        }
        StringBuilder right = new StringBuilder(left).reverse();
        left.append(0);
        left.append(right);

        return left.toString();
    }
}