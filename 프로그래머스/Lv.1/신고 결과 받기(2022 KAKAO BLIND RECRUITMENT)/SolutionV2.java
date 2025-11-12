import java.util.*;

class SolutionV2 {  // 기존꺼에서 List -> Set / id-index 하나 매칭 맵 생성


    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];
        Map<String, List<String>> reportMap = new HashMap<>();

        for (String s : id_list) {
            reportMap.put(s, new ArrayList<>());
        }

        for (String re : report) {
            String[] parts = re.split(" ");
            String reportUser = parts[0];
            String illegalUser = parts[1];

            if (reportMap.get(illegalUser).contains(reportUser)) {
                continue;
            }
            reportMap.get(illegalUser).add(reportUser);
        }



        for (int i = 0; i < id_list.length; i++) {
            if (reportMap.get(id_list[i]).size() >= k) {
                for (int j = 0; j < id_list.length; j++) {
                    if (reportMap.get(id_list[i]).contains(id_list[j])) {
                        answer[j]++;
                    }
                }

            }
        }
        return answer;
    }

}