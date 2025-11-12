import java.util.*;

class Solution {


    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> idIndexMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
            idIndexMap.put(id_list[i], i);
        }

        for (String re : report) {
            String[] parts = re.split(" ");
            reportMap.get(parts[1]).add(parts[0]);
        }


        for (String id : id_list) {
            if (reportMap.get(id).size() >= k) {
                for (String reporter : reportMap.get(id)) {
                    answer[idIndexMap.get(reporter)]++;
                }
            }
        }
        return answer;
    }

}