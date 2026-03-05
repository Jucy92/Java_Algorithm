import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String cmd = parts[0];
            String uid = parts[1];
            if ("Enter".equals(cmd) || "Change".equals(cmd)) {
                userMap.put(uid, parts[2]);
            }
        }

        List<String> result = new ArrayList<>();
        for (String r : record) {
            String[] parts = r.split(" ");
            String cmd = parts[0];
            String uid = parts[1];

            if ("Enter".equals(cmd)) {
                result.add(userMap.get(uid) + "님이 들어왔습니다.");
            } else if ("Leave".equals(cmd)) {
                result.add(userMap.get(uid) + "님이 나갔습니다.");
            }
        }
        return result.toArray(new String[0]);
    }
}