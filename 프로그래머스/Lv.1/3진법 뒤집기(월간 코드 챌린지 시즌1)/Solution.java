class Solution {
    public int solution(int n) {
//        String base3 = Integer.toString(n, 3);  // 3진수로 변환
//        String reverse = new StringBuilder(base3).reverse().toString(); // 변환 된 문자열 sb 통해서 뒤집고 String으로 변환
//        return Integer.parseInt(reverse, 3); // 뒤집힌 숫자의 진수로 10진수 변환
        return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3); // 체이닝 통해 간략화
    }
}