import java.util.Arrays;

class Solution {
    public int solution(String[] storage, String[] requests) {

        int n = storage.length;
        int m = storage[0].length();
        // 2차원 배열로 변환
        char[][] warehouse = new char[n][m];
        for (int i = 0; i < n; i++) {
            warehouse[i] = storage[i].toCharArray();
        }
        for (String request : requests) {
            char target = request.charAt(0);
            int size = request.length();

            if (size > 1) {
                removeAll(warehouse, target);
            } else {
                removeAccessible(warehouse, target);
            }
        }
        return countRemaining(warehouse);
    }

    private void removeAccessible(char[][] warehouse, char target) {
        int n = warehouse.length;
        int m = warehouse[0].length;
        boolean[][] toRemove = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((warehouse[i][j] == target) && isAccessible(warehouse, i, j)) {
                    toRemove[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (toRemove[i][j]) {
                    warehouse[i][j] = ' ';
                }
            }
        }
    }

    private boolean isAccessible(char[][] warehouse, int i, int j) {
        int n = warehouse.length;
        int m = warehouse[0].length;

        if (i == 0) return true;
        if (i == n - 1) return true;
        if (j == 0) return true;
        if (j == m - 1) return true;

        if (i > 0 && warehouse[i-1][j] == ' ') return true;
        if (i < n-1 && warehouse[i+1][j] == ' ') return true;
        if (j > 0 && warehouse[i][j-1] == ' ') return true;
        if (j < m-1 && warehouse[i][j+1] == ' ') return true;

        return false;

    }

    private void removeAll(char[][] warehouse, char target) {
        int n = warehouse.length;
        int m = warehouse[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (warehouse[i][j] == target) {
                    warehouse[i][j] = ' ';
                }
            }
        }
    }

    private int countRemaining(char[][] warehouse) {
        int n = warehouse.length;
        int m = warehouse[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (warehouse[i][j] == ' '){
                    count++;
                }
            }
        }
        return count;
    }
}
