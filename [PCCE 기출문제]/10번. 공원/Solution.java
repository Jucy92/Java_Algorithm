import java.util.*;

public class Solution {

    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        List<Integer> matsSort = new ArrayList<>();
        for (int mat : mats) {
            matsSort.add(mat);
        }
        matsSort.sort(Collections.reverseOrder());

        int rows = park.length;
        int cols = park[0].length;

        for (Integer matSize : matsSort) {
            if (canPlaceMat(park, rows, cols, matSize)) {   // rows = 6, cols = 8, matSize = 5,3,2
                return matSize;
            }
        }
        return -1;
    }

    private boolean canPlaceMat(String[][] park, int rows, int cols, Integer matSize) {
        for (int i = 0; i <= rows - matSize; i++) {  // 0~1
            for (int j = 0; j <= cols - matSize; j++) {  // 0~3
                if (canPlaceAt(park, i, j, matSize)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canPlaceAt(String[][] park, int startRow, int startCols, Integer matSize) {
        for (int i = startRow; i < startRow + matSize; i++) {
            for (int j = startCols; j < startCols + matSize; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }

}

