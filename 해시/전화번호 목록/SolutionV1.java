public class SolutionV1 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        /* 아래 방법으로 앞뒤 비교 문제 해결
        for (int i = 0; i < phone_book.length; i++) {   // length = 3이라면 -> 0,1,2       length-1 = 2이라면 ->  2<2 => 거짓// 0,1만 돔
            for (int j = i + 1; j < phone_book.length; j++) {   //         -> 1,2                                   => 1
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return true;

        */

    /*
     */
    for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) {return false;}
                if(phone_book[j].startsWith(phone_book[i])) {return false;}
            }
        }
        return true;
    }

}


