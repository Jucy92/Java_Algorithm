import java.util.HashMap;
import java.util.Map;

public class SolutionV3 {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
//                System.out.println("i = " + i + ", phone_book[" + i +"]" + " = " + phone_book[i]);
//                System.out.println("j = " + j + ", str = " + phone_book[i].substring(0,j));
                if (map.containsKey(phone_book[i].substring(0,j))) { // 123[0], 6[1], 6789[2]가 있을 경우 phone_book[2]에서 6검색할 때 첫번째에서 바로 포함된 결과 나옴
                    return false;
                }
            }
        }
        return true;
    }
}


