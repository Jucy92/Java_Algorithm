import java.util.*;

public class Solution {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 1. ext의 val_ext 기준 으로 작은 데이터 추출하고 sort_by에 맞춰 오름차순

        int index = getColumnIndex(ext);
        int sort = getColumnIndex(sort_by);
        List<int[]> filterData = new ArrayList<>();


        for (int[] unit : data) {
            if (unit[index] < val_ext) {
                filterData.add(unit);
            }
        }
        filterData.sort((a,b) -> Integer.compare(a[sort], b[sort]));

        return filterData.toArray(new int[filterData.size()][]);
    }

    private int getColumnIndex(String column) {
        switch (column) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: throw new IllegalArgumentException("유효하지 않은 입력 값 : " + column);
        }
    }

}

