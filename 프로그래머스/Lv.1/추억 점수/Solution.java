import java.util.*;
import java.util.stream.Stream;

public class Solution {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        Map<String, Integer> affectionPoint = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            affectionPoint.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String friendName : photo[i]) {
                if (affectionPoint.containsKey(friendName)) {
                    sum += affectionPoint.get(friendName);
                }
            }
            result[i] = sum;
        }

        return result;
    }

}

