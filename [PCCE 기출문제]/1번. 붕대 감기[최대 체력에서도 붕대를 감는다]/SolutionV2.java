import java.util.*;

public class SolutionV2 {

    // 개선된 버전
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int consecutiveTime = 0;
        int attackIndex = 0;

        // 1. 명확한 루프 종료 조건 - 마지막 공격 시간까지만
        int lastAttackTime = attacks[attacks.length - 1][0];

        for (int currentTime = 1; currentTime <= lastAttackTime; currentTime++) {
            boolean wasAttacked = false;

            // 2. 공격 체크 - 더 간단한 조건
            if (attackIndex < attacks.length && attacks[attackIndex][0] == currentTime) {
                health -= attacks[attackIndex][1];
                consecutiveTime = 0;
                wasAttacked = true;
                attackIndex++;

                // 즉시 사망 체크
                if (health <= 0) {
                    return -1;
                }
            }

            // 3. 회복 로직 - 조건 최적화
            if (!wasAttacked /*&& health < maxHealth*/) {   // 테스트 케이스에서 taping 횟수를 체크한건가.. 이거 때문에 테스트케이스 실패했었음
                consecutiveTime++;
                health += bandage[1];

                // 연속 성공 보너스
                if (consecutiveTime == bandage[0]) {
                    consecutiveTime = 0;
                    health += bandage[2];
                    // 최대 체력 제한 (필요시)
                    if (health > maxHealth) {
                        health = maxHealth;
                    }
                }
            }
        }

        return health;
    }
}