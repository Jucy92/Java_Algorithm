import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        int startRow = 0, startCol = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(park[i].charAt(j)=='S'){
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int currentRow = startRow;
        int currentCol = startCol;
        for(String route : routes){
            String[] parts = route.split(" ");
            String direction = parts[0];
            Integer distance = Integer.valueOf(parts[1]);

            int dRow = 0, dCol = 0;
            switch(direction){
                case "E" : dCol = 1; break;
                case "W" : dCol = -1; break;
                case "N" : dRow = -1; break;
                case "S" : dRow = 1; break;
            }
            int tempRow = currentRow, tempCol = currentCol;
            boolean canMoved = true;
            for(int i= 1; i<=distance; i++){
                tempRow += dRow;
                tempCol += dCol;

                if(tempRow < 0 || tempCol < 0 || tempRow >= n || tempCol >= m){
                    canMoved = false;
                    break;
                }
                if(park[tempRow].charAt(tempCol) == 'X'){
                    canMoved = false;
                    break;
                }
            }
            if(canMoved){
                currentRow = tempRow;
                currentCol = tempCol;
            }

        }


        return new int[]{currentRow, currentCol};
    }
}