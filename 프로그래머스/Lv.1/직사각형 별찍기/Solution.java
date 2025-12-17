import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String line = "*".repeat(a);
        StringBuilder sb = new StringBuilder((a+1)*b);

        for (int i = 0; i < b; i++) {
            sb.append(line).append("\n");
        }

        System.out.println(sb);
    }

}