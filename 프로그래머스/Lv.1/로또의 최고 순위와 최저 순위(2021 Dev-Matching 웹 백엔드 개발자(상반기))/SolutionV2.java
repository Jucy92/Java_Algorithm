import java.util.HashMap;
import java.util.Map;

class SolutionV2 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        // 순위 체크 6개-1, 5개-2....1or0개-6(낙)
        Map<Integer, Integer> rankMap = new HashMap<>();
        rankMap.put(6, 1);
        rankMap.put(5, 2);
        rankMap.put(4, 3);
        rankMap.put(3, 4);
        rankMap.put(2, 5);
        rankMap.put(1, 6);
        rankMap.put(0, 6);
        int count = 0;
        int unknown = 0;
        for (int win_num : win_nums) {
            for (int num : lottos) {
                if (win_num == num) {
                    count++;
                }

            }
        }
        for (int num : lottos) {
            if (num == 0) {
                unknown++;
            }
        }

        return new int[]{rankMap.get(count + unknown), rankMap.get(count)};

    }


}