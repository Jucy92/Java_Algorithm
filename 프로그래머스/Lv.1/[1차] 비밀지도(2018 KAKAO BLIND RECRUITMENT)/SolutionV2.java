import java.util.*;

class SolutionV2 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        boolean[][] visited = new boolean[n][n]; // 이렇게 체크하고 true인 곳을 #으로 바꿔줄 것인가..
        // 아니면 그냥 string에 바로 sb를 사용하든..해서 담아줄것인가..
        for (int i = 0; i < n; i++) {
            String strings = Integer.toString(arr1[i], 2);
//            System.out.println("10진수 = " + arr1[i] + ", 2진수 = " + strings + ", size = " + strings.length());
            int diff = n - strings.length();
            for (int j = diff; j < n; j++) {
                map1[i][j] = strings.charAt(j - diff) - '0';
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            String strings = Integer.toString(arr2[i], 2);
//            System.out.println("10진수 = " + arr2[i] + ", 2진수 = " + strings + ", size = " + strings.length());
            int diff = n - strings.length();
            for (int j = diff; j < n; j++) {
                map2[i][j] = strings.charAt(j- diff) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {   // 의미 없이 처음에 다 false이기 때문에 들어오긴 할텐데.. (쓸모없는)안전장치...?
                    if (map1[i][j] == 1 || map2[i][j] == 1) {
                        visited[i][j] = true;
                    }
                }
            }
        }

        /**
         * // visited 배열은 사실 필요 없어요! map1과 map2만으로도 충분
         * for (int i = 0; i < n; i++) {
         *     StringBuilder sb = new StringBuilder();
         *     for (int j = 0; j < n; j++) {
         *         if (map1[i][j] == 1 || map2[i][j] == 1) {
         *             sb.append("#");
         *         } else {
         *             sb.append(" ");
         *         }
         *     }
         *     answer[i] = sb.toString();
         * }
         */


//        System.out.println("map1 = " + Arrays.deepToString(map1));
//        System.out.println("map2 = " + Arrays.deepToString(map2));
//        System.out.println("visited = " + Arrays.deepToString(visited));

        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < visited[i].length; j++) {
                if (visited[i][j]) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}