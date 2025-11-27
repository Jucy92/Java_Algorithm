class SolutionV2 {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        //System.out.println("sb = " + sb);
        int len = sb.length();
        //System.out.println("len = " + len);
        for (int i = 1; i <= len; i++) {
            char c = sb.charAt(i - 1);
            int num = 1;
            if (c == '0') {
                continue;
            }
            //System.out.println("char = " + c + ", 3의 " + (len - i) + "제곱");
            for (int j = 1; j <= len - i; j++) {    // len - (i가 들어가는 지 j가 들어가는 지 헷갈리면) 위에서 int repeat = len - i 선언해서 그냥 몇번 반복하는 지 변수에 담아...
                //System.out.println("반복 횟수 = " + j);
                num *=  3;
            }
            if (len - i == 0) {
                num = 1;
            }
            //System.out.println("num = " + num);
            answer += Character.getNumericValue(c) * num;
        }
        return answer;
    }
}