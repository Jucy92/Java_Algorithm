import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionV2 solution2 = new SolutionV2();
        int [] scoville = {1, 2, 3, 9, 10, 12};


        System.out.println(solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7)); // -> return 2

        /**
         * 문제 접근 방식
         * 1. 뭔가 정렬하면서 값을 넣어주는 큐인지 맵인지 뭔가 있었던거 같은데 일단 풀어보자에서 출발
         *  -> 첫 번째 큐 접근 Queue<Integer> underScoville = new ArrayDeque<>(); 값을 꺼내고, 큐안에 값을 비교하면서  첫번째 값과 두번째 값을 꺼내려면 poll, offer 작업을 여러번 해야 해서 복잡도 문제 발생
         *  -> 두 번째 리스트 접근 List<Integer> underScoville = new ArrayList<>(); 인덱스로 관리하면서 값 찾는건 했으나, 연산을 위해 값을 뺴는 과정에서 인덱스로 접근하기 때문에 순서 틀어짐 발생
         *
         * 2. 이로써 포기하고 검색해서 PriorityQueue<Integer> underScoville = new PriorityQueue<>(); 으로 접근
         *
         */
    }
}
