public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int result = solution.solution(clothes);
        System.out.println("result = " + result);
    }
}