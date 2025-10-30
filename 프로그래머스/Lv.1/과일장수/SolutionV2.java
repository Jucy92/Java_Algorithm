import java.util.*;

class SolutionV2 {  // 꾸역꾸역 그냥 돌아가게 만듬
    public int solution(int k, int m, int[] score) throws InterruptedException {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int count=0;
        List<Integer> box = new ArrayList<>();
        for (int grade : score) {
            pq.add(grade);
        }
        while(!pq.isEmpty()){
            if (box.size() < m) {
                box.add(pq.poll());
            } else {
                Integer boxMin = Collections.min(box);
                answer += boxMin * m;
                box.clear();
            }
        }
        if (box.size() == m) {
            Integer boxMin = Collections.min(box);
            answer += boxMin * m;
        }
        return answer;
    }


    /*
    int n, m;
    char[][] map;
    boolean[][] accessible;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();

        // 패딩을 포함한 맵 생성 (외부를 '.' 로)
        map = new char[n + 2][m + 2];

        // 패딩 부분을 '.'로 초기화
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                map[i][j] = '.';
            }
        }

        // 실제 데이터 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        // 각 요청 처리
        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 1) {
                // 지게차: 외부 접근 가능한 것만 제거
                removeAccessible(target);
            } else {
                // 크레인: 모두 제거
                removeAll(target);
            }
        }

        // 남은 컨테이너 개수 세기
        return countRemaining();
    }

    // 외부에서 접근 가능한 컨테이너 제거
    private void removeAccessible(char target) {
        // 외부(0,0)에서 시작하는 BFS로 '.'을 통해 접근 가능한 모든 칸 찾기
        accessible = new boolean[n + 2][m + 2];
        Queue<int[]> queue = new LinkedList<>();

        // (0,0)은 항상 '.' (외부)
        queue.offer(new int[]{0, 0});
        accessible[0][0] = true;

        // BFS: '.'인 칸들을 통해 퍼져나감
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n + 2 && ny >= 0 && ny < m + 2
                        && !accessible[nx][ny]) {
                    accessible[nx][ny] = true;

                    // '.'인 경우에만 계속 퍼져나감
                    if (map[nx][ny] == '.') {
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // 접근 가능하고 target인 것들만 제거
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (accessible[i][j] && map[i][j] == target) {
                    map[i][j] = '.';
                }
            }
        }
    }

    // 해당 종류 모두 제거
    private void removeAll(char target) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == target) {
                    map[i][j] = '.';
                }
            }
        }
    }

    // 남은 컨테이너 개수
    private int countRemaining() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '.') {
                    count++;
                }
            }
        }
        return count;
    }
    */
}