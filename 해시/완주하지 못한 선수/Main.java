public class Main {
    public static void main(String[] args) {
        //String[] participant = {"leo", "kiki", "eden"};
        //String[] completion = {"eden", "kiki"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Solution solution = new Solution();
        solution.solution(participant, completion);
        System.out.println(solution.solution(participant, completion));
    }
}