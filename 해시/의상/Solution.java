import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[][] clothes) {
        // clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]] => 5
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1],0)+1);
        }
        // (최대 개수 +1)! - 1
        int cnt = 1;
        for (Integer value : map.values()) {
            cnt *= (value+1);
        }
        answer = cnt - 1;

        return answer;
    }
}
