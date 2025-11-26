import java.util.Arrays;

class SolutionV2 {
    public String solution(String new_id) { // 여기는 SB 사용해서 처리 해보자

//        char[] chars = new_id.toCharArray();
        StringBuilder sb = new StringBuilder(new_id);
//      1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        step1(sb);

//      2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        step2(sb);

//      3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        step3(sb);
//
//      4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        step4(sb);
//
//      5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        step5(sb);
//
//      6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//           만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        step6(sb);
//
//      7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        step7(sb);
        return sb.toString();
    }

    private void step7(StringBuilder sb) {
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
//        System.out.println("step7.sb = " + sb);
    }

    private void step6(StringBuilder sb) {
        int size = sb.length();
        if (size > 15) {
            sb.delete(15, size);
            //sb.setLength(15);
            if (sb.charAt(sb.length()-1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
                //sb.setLength(14);
            }
        }

//        System.out.println("step6.sb = " + sb);
    }

    private void step5(StringBuilder sb) {
        if (sb.isEmpty()) {
            sb.append("a");
        }
//        System.out.println("step5.sb = " + sb);
    }

    private void step4(StringBuilder sb) {

        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
//        System.out.println("step4.sb = " + sb);
    }

    private void step3(StringBuilder sb) {
        for (int i = 0; i < sb.length()-1;) {
            if (sb.charAt(i) == '.' && sb.charAt(i + 1) == '.') {
                sb.deleteCharAt(i);
            } else {
                i++;
            }
        }
//        System.out.println("step3.sb = " + sb);
    }

    private void step2(StringBuilder sb) {
        //char[] special_characters = "-_.~!@#$%^&*()=+[{]}:?,<>/".toCharArray();
        for (int i = 0; i < sb.length();) {
            char ch = sb.charAt(i);
            if (!isAllowed(ch)) {
                sb.deleteCharAt(i);
            } else {
                i++;
            }
            /*
            for (int j = 0; j < special_characters.length; j++) {
                if (ch != '-' && ch != '_' && ch != '.') {  
                    sb.deleteCharAt(i); // 이대로 돌렸으면 오류 생겼었겠다 i는 계속 증가하고 i는 하나 없어지니 갭 생겨서
                }
            }
            */
        }
//        System.out.println("step2.sb = " + sb);

    }

    private void step1(StringBuilder sb) {
//        for (char ch : validUserId) {
//            if (65 <= ch && ch <= 90) {
//                ch += 32;   // 포이치문은 그냥 문자를 복사해서 가져오는 것 => 값 변경 x
//            }
//        }
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.setCharAt(i,(char)(ch+32));
            }
        }
//        System.out.println("step1.sb = " + sb);
    }

    private boolean isAllowed(char ch) {
        return (ch >= 'a' && ch <= 'z') ||
               (ch >= '0' && ch <= '9') ||
                ch == '-' || ch == '_' || ch == '.';
    }

}