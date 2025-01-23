import java.util.*;

public class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();    // key 중복 될 경우 value +1 -> 중복 처리, 앞 뒤 값 처리

        for (String operation : operations) {
            String[] data = operation.split(" ");
            Integer value = Integer.valueOf(data[1]);
            String dml = data[0];

            if (dml.equals("I")) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            } else if (dml.equals("D") && !map.isEmpty()) {
                Integer key = (value == 1) ? map.lastKey() : map.firstKey();
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }
        }
        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{map.lastKey(), map.firstKey()};
    }
}