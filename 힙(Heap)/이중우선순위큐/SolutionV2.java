import java.util.*;

public class SolutionV2 {     // 미완성 코드 -> 놓쳤던 1가지 문제점 중복 값이 들어올 경우 처리가 안됨...
    public int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>();  // 정렬 + 앞 뒤 삽입 삭제 가능   -> 놓쳤던 1가지 문제점 중복 값이 들어올 경우 처리가 안됨...

        //System.out.println("operations = " + Arrays.toString(operations));
        for (String operation : operations) {
            //System.out.println("operation = " + operation);
            String[] data = operation.split(" ");
            Integer value = Integer.valueOf(data[1]);
            String dml = data[0];
            //System.out.printf("DML = " + dml);
            //System.out.println(" value = " + value);

            if (dml.equals("I")) {
                set.add(value);
            } else if (dml.equals("D") && !set.isEmpty()) {
                if (value.equals(-1)) {
                    //System.out.println("set.first() = " + set.first());
                    set.pollFirst();

                } else if (value.equals(1)) {
                    //System.out.println("set.last() = " + set.last());
                    set.pollLast();
                }
            }
            //System.out.println("set = " + set);
        }
        if (set.isEmpty()) {
            return new int[]{0,0} ;
        }
        return new int[]{set.last(), set.first()};
    }

}
