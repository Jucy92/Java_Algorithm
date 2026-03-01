class Solution {
    private static final int[] discountPercent = {40, 30, 20, 10};

    public int[] solution(int[][] users, int[] emoticons) {
        int[] selectedRates = new int[emoticons.length];

        return dfs(0, users, emoticons, selectedRates);

    }

    private int[] dfs(int depth, int[][] users, int[] emoticons, int[] selectedRates) {
        int[] best = new int[2];
        // 할인율 다 적용되면 계산 로직 수행
        if (depth == emoticons.length) {
            for (int i = 0; i < users.length; i++) {
                int percent = users[i][0];
                int money = users[i][1];

                int totalPrice = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    // 구매 가능한 할인율 인 경우 구매
                    if (percent <= selectedRates[j]) {
                        totalPrice += (emoticons[j] * (100 - selectedRates[j])) / 100;
                    }
                }
                // 이모티콘 목록 확인 후 결제 방법 선택(구독/계산)
                if (money <= totalPrice) {
                    best[0]++;
                } else {
                    best[1] += totalPrice;
                }
            }
            return best;
        }
        for (int i = 0; i < discountPercent.length; i++) {
            selectedRates[depth] = discountPercent[i];
            int[] current = dfs(depth + 1, users, emoticons, selectedRates);

            // best 최종 값 관리 / current 한 회차에서 리턴 받은 값 관리
            /*  // 이거 아래 한줄로 처리
            if (best[0] < current[0]) {
                best[0] = current[0];
                best[1] = current[1];
            } else if (best[0] == current[0] && best[1] < current[1]) {
                best[1] = current[1];
            }
            */
            if (best[0] < current[0] || (best[0] == current[0] && best[1] < current[1])) {
                best = current;
            }

        }
        return best;
    }

}