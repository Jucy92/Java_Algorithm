public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 10, new int[]{7, 4, 5, 6})); // 8
        System.out.println(solution.solution(100, 100, new int[]{10})); // 101
        System.out.println(solution.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})); // 110
    }
}
