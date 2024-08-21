public class Main {
    public static void main(String[] args) {
//        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"12", "6789", "6"};  // V1 오답 => 변경

        SolutionV1 solution1 = new SolutionV1();
        System.out.println(solution1.solution(phone_book));

        SolutionV2 solution2 = new SolutionV2();
        System.out.println(solution2.solution(phone_book));

        SolutionV3 solution3 = new SolutionV3();
        System.out.println(solution3.solution(phone_book));
    }
}