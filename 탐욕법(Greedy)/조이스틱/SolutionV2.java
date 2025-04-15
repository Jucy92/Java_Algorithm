import java.util.Arrays;

class SolutionV2 {      // 타임아웃 30분 초과  -> 미완성
    public int solution(String name) { // JEROEN -> 56
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""); // 26개 0~25
        // 알파벳 위치를 일단 트리로 해서 어디로 이동하는게 빠를지 판단해야할거같은데
        int count = 0;

        for (String s : name.split("")) {
            for (int i = 0; i < alphabet.length; i++) {
                System.out.println("s = " + s);
                System.out.println("alphabet = " + alphabet[i]);
                if (s.equals(alphabet[i])) {
                    System.out.println("문자 같을 때 count = " + count);
                    break;
                }
                count++;
                System.out.println("count = " + count);
            }
            count++;    // 다음칸 키조작
        }

        return count;
    }

}