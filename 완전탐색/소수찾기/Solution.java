import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        // 1. 숫자 조합 생성
        generateNumbers("", numbers);

        // 2. 소수 개수 체크
        int count = 0;
        for (Integer num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    private void generateNumbers(String prefix, String remaining) {
        if (!prefix.isEmpty()) {
            numberSet.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < remaining.length(); i++) {
            generateNumbers(prefix+remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i+1));
        }
        // remaining = 17, 011  substring(여기 인덱스부터,여기 인덱스전까지), substring(인덱스부터 뒤로 쭉)
        // i = 0 -> remaining.substring(0,i) = "", remaining.substring(i+1)) = 7
        // i = 1 -> remaining.substring(0,i) = 1, remaining.substring(i+1)) = ""
    }

    private boolean isPrime(Integer num) {
        if (num <= 1) return false; // 1이하는 포함 x
        if (num == 2) return true;  // 2는 약수
        if (num % 2 == 0) return false; // 2로 나눴을 때 나머지가 없음 (2의 배수로 소수가 아님)

        for (int i = 3; i * i <= num; i += 2) { // 최소 3부터 검증
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}

