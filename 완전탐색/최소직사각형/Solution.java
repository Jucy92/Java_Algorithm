import java.util.*;

class Solution {
    public int solution(int[][] sizes) {    // {60, 50}, {30, 70}, {60, 30}, {80, 40}
        int maxWidth = 0;
        int maxHeight = 0;

        // 1. 배열 내 최대(w저장) 값 최소(h저장) 값을 구하고
        // 2. 그 값 중 최대 값 찾기
        for (int[] size : sizes) {
            int currentMax = Math.max(size[0], size[1]);
            int currentMin = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, currentMax);
            maxHeight = Math.max(maxHeight, currentMin);
        }

        return maxWidth * maxHeight;

     /*
        int size = sizes.length;
        int[] valueCheck = new int[size];
        int maxW = 0, maxH = 0;
        int index = 0;
        List<ValueCheck> list = new ArrayList<>();
        System.out.println("size = " + size);

        // 1. w,h 최대값을 구하고
        // 2. 작은 최대 값의 반대 값으로 변경하면서 최소 크기를 찾는다 -> 해당 인덱스 번호 제외하고 다시 최소 값을 구해..? n^2이 되겠네
        for (int[] ints : sizes) {
            // 왼쪽(W)이 크면 0 오른쪽(H)이 크면 1
            if (ints[0] < ints[1]) {
                valueCheck[index] = 1;
                list.add(new ValueCheck(index++, 1));
            } else {
                valueCheck[index] = 0;
                list.add(new ValueCheck(index++, 0));
            }

            if (ints[0] > maxW) {
                maxW = ints[0];
            }
            if (maxH < ints[1]) {
                maxH = ints[1];
            }
        }

        System.out.println("maxW = " + maxW);
        System.out.println("maxH = " + maxH);
        System.out.println("list = " + list);
        return 0;
    }

    public class ValueCheck {
        int index;
        int direction;

        public ValueCheck(int index, int direction) {
            this.index = index;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "ValueCheck{" +
                    "index=" + index +
                    ", direction=" + direction +
                    '}';
        }
    }
    */
    }
}

