import java.util.*;

class SolutionV2 {  // 테스트 실패 케이스
    public String solution(String s, String skip, int index) {

        StringBuilder sb = new StringBuilder();
        for (char character : s.toCharArray()) {
            int asciiNum = (int) character;

            for (int i = 0; i < index; i++) {
                asciiNum += 1;
                for (char passCharacter : skip.toCharArray()) { // 여기가 문제 bfdc 같이 순서가 뒤에 있다면 skip 횟수만 반복하기 때문에 뒤에 있는 fd는 통과되고 체크되지 못함
                    int passNum = passCharacter;

                    if (asciiNum > 122) asciiNum = 97;
                    if (passNum == asciiNum) {
                        asciiNum+=1;        
                    }
                }
            }
            sb.append((char)asciiNum);
        }

        return sb.toString();
    }


}