import java.util.*;

public class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int result = 0;

        // t는 붕대 감는 시간, x 회복량 t완료 시 + y체력
        // bandage={시전시간,회복량(x),추가회복량(y)} / health=최대체력 / attacks={공격시간,피해량}
        // 모든 공격이 끝난 후 남은 체력 리턴 attacks[i][0]의 마지막 값이 최종 공격 시간
        int maxHealth = health;
//        for (int i = 0; i < attacks.length; i++) {
        int timer = 0;
        int index = 0;
        int taping = 0;
        while (true) {

            boolean attacked = false;
            if (health <= 0) {
                return -1;
            }
            if (attacks[index][0] == timer) {
                health -= attacks[index][1];
                taping = 0;
                attacked = true;
                if (index < attacks.length -1) {
                    index++;    // 조건을 생략하면 index 가 length 보다 커지면 오류터지는데?
                } else {    // 여기서 마지막 인덱스를 처리해주고 나면, 끝이라고 생각해서 그냥 그 값을 리턴해줬는데, 마지막 처리로 0이 된 경우 -1이 아닌 0이 출력된다.. 아래 체크 한번 더
                    if (health <= 0) {
                        return -1;
                    }
                    return health;
                }

            }
            if (!attacked){
                if ((health < maxHealth)) {
                    // 시간이 흘러가는 걸 처리했다고 가정 하고 다음 스탭 -> 아마 maxHealth 밖에서 처리해야할듯 한단계 윗단으로
                    taping++;
                    health += bandage[1];   // 시간이 흘러가는 걸 표현 x
                    if (taping == bandage[0]) {
                        taping = 0;
                        health += bandage[2];
                    }
                }
            }

            timer++;
        }

    }

}

