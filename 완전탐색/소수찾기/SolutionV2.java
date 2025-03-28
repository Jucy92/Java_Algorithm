import java.util.*;

class SolutionV2 {
    Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        // 1. 문자열 잘라서 숫자화 -> ASCII 코드 "17" -> split("") 통해서 나눔
        //                     ㄴ> 7자리가 정해져있으니깐 parseInt로 숫자화 하고 10씩 나눠..? -> 맨 앞자리 0 사라짐 => X
        // 2. 소수 구하는 방법 -> 1,2,3,5,7,11,13... 로 안나눠지는거? 1과 자기 자신 수로만 나눌 수 있는거..
        // 3. 숫자 조합표 -> 파츠를 하나씩 섞어가면서 구하고, Set에 담아서 처리?
        //             ㄴ> 재귀함수 사용해서

        String[] parts = numbers.split("");     //  1<= parts.length(길이) <= 7
        boolean[] visited = new boolean[parts.length];

        generatePermutations(parts, visited, "", 0);

        int count = 0;
        for (Integer num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    private void generatePermutations(String[] parts, boolean[] visited, String current, int depth) {
        if (depth > 0) {
            numberSet.add(Integer.parseInt(current));
        }
        for (int i = 0; i < parts.length; i++) {    // length = 3[0,1,1]
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(parts, visited, current + parts[i], depth + 1);
                visited[i] = false;
            }
        }

    }

    private boolean isPrime(Integer num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

