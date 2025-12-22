import java.util.stream.*;

class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();
        return IntStream.range(0, length)
                .mapToObj(i -> i < length - 4 ? "*" : String.valueOf(phone_number.charAt(i)))
                .collect(Collectors.joining());
    }
}