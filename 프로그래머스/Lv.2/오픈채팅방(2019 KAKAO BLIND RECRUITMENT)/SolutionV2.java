import java.util.*;

class SolutionV2 {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String[]> list = new ArrayList<>();

        for (String str : record) {
            String[] parts = str.split(" ");
            String status = parts[0];
            String userId = parts[1];
            if (status.startsWith("Enter")) {
                userMap.put(userId, parts[2]);
                list.add(new String[]{userId,"님이 들어왔습니다."});

            } else if (status.startsWith("Change")) {
                userMap.put(userId, parts[2]);
            } else {
                list.add(new String[]{userId,"님이 나갔습니다."});

            }
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String[] parts = list.get(i);
            String nickname = userMap.get(parts[0]);
            answer[i] = nickname + parts[1];
        }

        return answer;
    }
}