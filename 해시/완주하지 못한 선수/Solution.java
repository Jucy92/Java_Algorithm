import java.util.*;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) { // 전체 인원
            map.put(player, map.getOrDefault(player, 0)+1);
        }

        for (String player : completion) {  // 통과 인원
            int count = map.get(player) - 1;
            map.put(player, count);

            if (count <= 0) {
                map.remove(player);
            }
        }

        return map.keySet().iterator().next();
        //return map.entrySet().iterator().next().getKey();

        /*
        Iterator<Map.Entry<String, Integer>> entrySet = map.entrySet().iterator();  // Iterator next 하지 않으면 객체 참조값을 가르키고 있다. next 해야 실 데이터 가르킴
        System.out.println("entrySet.iterator = " + entrySet.next().getKey());  // => mislav
        System.out.println("entrySet.toString = " + map.entrySet().toString());   // => [mislav=1]


        Iterator<String> keySet = map.keySet().iterator();
        System.out.println("keySet.iterator = " + keySet.next());         // => mislav
        System.out.println("keySet.toString = " + map.keySet().toString()); // => keySet.toString = [mislav]
        */


        /* // 배열로 비교하면서 처리
        Arrays.sort(participant); // 전체 인원
        Arrays.sort(completion);  // 완주 인원
        int i;

        for (i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {    // 정렬을 했기 때문에 같지 않으면 다른 정보가 들어가 있는거
                return participant[i];
            }
        }
        return participant[i];
         */


        /*  // 문제를 제대로 못봐서 잘못된 접근이긴 하나, 1개 이상 차이가 나는 데이터를 출력하려면 위 방법으로 iter 돌리면서 sb.append 사용하면 될 듯
        Set<String> pSet = new HashSet<>(List.of(participant));
        pSet.removeAll(List.of(completion));
        //System.out.println("pSet = " + pSet);

        StringBuilder sb = new StringBuilder();
        for (String s : pSet) {
            sb.append(s);
        }
        String s = sb.toString();

        return s;
        */
    }
}
