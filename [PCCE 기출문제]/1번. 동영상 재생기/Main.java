public class Main {
    public static void main(String[] args) {


        Solution solution = new Solution();
        System.out.println(solution.solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(solution.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next","next"}));
        System.out.println(solution.solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));

    }
}
