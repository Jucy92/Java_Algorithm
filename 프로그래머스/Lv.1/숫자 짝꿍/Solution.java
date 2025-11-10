import java.util.*;

class Solution {


    public String solution(String X, String Y) {
        /**
         * 간단한데.. 왜 문제를 풀려면 어렵게 가는 거 같냐..
         * X,Y 각 문자의 개수를 구한다.
         * 공통 숫자로 가장 큰 수를 만든다.
         */
        Map<Character, Integer> mapX = new HashMap<>();
        Map<Character, Integer> mapY = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            mapX.put(X.charAt(i), mapX.getOrDefault(X.charAt(i), 0) + 1);
        }
        for(char ch: Y.toCharArray()){
            mapY.put(ch, mapY.getOrDefault(ch, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        // ex = 3403 , 13203 -> 3 3 0
        for (Character x : mapX.keySet()) {
            if (mapY.containsKey(x)) {
                int minCount = Math.min(mapX.get(x), mapY.get(x));
                for (int i = 0; i < minCount; i++) {
                    list.add(String.valueOf(x));
                }
            }
        }
        if (list.isEmpty()) {
            return "-1";
        }
        /*
        // 리스트에 값 담은 상태로 내림차순 비교
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        */
        // 람다 방식으로 내림차순 정렬
        //list.sort((s1, s2) -> s2.compareTo(s1));
        // 그냥 역정렬... -> 리스트에 이미 정답인 숫자만 들어가 있으니.. 큰 숫자를 만들기 위해서 내림차순하고 문자화..
        list.sort(Comparator.reverseOrder());


        if (list.get(0).equals("0")) {  // 내림 차순이기 때문에 맨 앞에가 0이면 뒤에는 0 보다 작은 수
            return "0";
        }
        return String.join("", list);
    }

}