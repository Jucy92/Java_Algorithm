import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 1. 실제로 캘 수 있는 광물의 개수
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMine = Math.min(minerals.length, totalPicks * 5);

        // 2. 광물을 5개씩 그룹으로 나누고 각 그룹의 난이도 계산
        List<MineralGroup> groups = new ArrayList<>();

        for (int i = 0; i < maxMine; i += 5) {
            int diamond = 0, iron = 0, stone = 0;

            // 5개씩 또는 남은 개수만큼
            for (int j = i; j < Math.min(i + 5, maxMine); j++) {
                if (minerals[j].equals("diamond")) diamond++;
                else if (minerals[j].equals("iron")) iron++;
                else stone++;
            }

            groups.add(new MineralGroup(diamond, iron, stone));
        }

        // 3. 난이도가 높은 그룹부터 정렬 (다이아몬드 많은 순)
        Collections.sort(groups, (a, b) -> {
            // 가중치: 다이아=25, 철=5, 돌=1 (돌 곡괭이 기준)
            int weightA = a.diamond * 25 + a.iron * 5 + a.stone;
            int weightB = b.diamond * 25 + b.iron * 5 + b.stone;
            return weightB - weightA; // 내림차순
        });

        // 4. 좋은 곡괭이부터 배정하여 피로도 계산
        int answer = 0;
        int groupIdx = 0;

        // 피로도 테이블
        int[][] fatigue = {
                {1, 1, 1},    // 다이아 곡괭이
                {5, 1, 1},    // 철 곡괭이
                {25, 5, 1}    // 돌 곡괭이
        };

        // 다이아 곡괭이 사용
        for (int i = 0; i < picks[0] && groupIdx < groups.size(); i++) {
            MineralGroup group = groups.get(groupIdx++);
            answer += group.diamond * fatigue[0][0]
                    + group.iron * fatigue[0][1]
                    + group.stone * fatigue[0][2];
        }

        // 철 곡괭이 사용
        for (int i = 0; i < picks[1] && groupIdx < groups.size(); i++) {
            MineralGroup group = groups.get(groupIdx++);
            answer += group.diamond * fatigue[1][0]
                    + group.iron * fatigue[1][1]
                    + group.stone * fatigue[1][2];
        }

        // 돌 곡괭이 사용
        for (int i = 0; i < picks[2] && groupIdx < groups.size(); i++) {
            MineralGroup group = groups.get(groupIdx++);
            answer += group.diamond * fatigue[2][0]
                    + group.iron * fatigue[2][1]
                    + group.stone * fatigue[2][2];
        }

        return answer;
    }

    // 광물 그룹 클래스
    static class MineralGroup {
        int diamond, iron, stone;

        MineralGroup(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
}