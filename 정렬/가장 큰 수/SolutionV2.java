import java.util.*;

class SolutionV2 {
    public String solution(int[] numbers) {
        // 숫자를 문자열로 변환하여 배열에 저장
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        //System.out.println("strNumbers = " + Arrays.toString(strNumbers));

        // 커스텀 Comparator를 사용하여 정렬
        // 두 문자열을 이어붙였을 때 더 큰 수가 되도록 정렬
        Arrays.sort(strNumbers, new Comparator<String>() {  // sort 정렬 할 때 배열 순서 보장 x -> (6,10,2) 순으로 하지 않고 (10,2,6) 무작위 순서로 비교함
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);    // (b+a)랑 (a+b)비교 했을 때 (b+a)가 크면 양수 리턴 -> b가 a의 앞(왼쪽)으로 이동, (a+b)가 크면 음수 리턴 -> b가 a의 뒤(오른쪽)로 이동
                // (b + a).compareTo(a + b) 내림차순, (a + b).compareTo(b + a) 오름차순
            }
        });
        //System.out.println("strNumbers = " + Arrays.toString(strNumbers));


        // 모든 숫자가 0인 경우를 처리 (예: [0, 0, 0] -> "0")
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자열을 이어붙여서 결과 생성
        StringBuilder sb = new StringBuilder();
        for (String str : strNumbers) {
            sb.append(str);
        }

        return sb.toString();
    }

}