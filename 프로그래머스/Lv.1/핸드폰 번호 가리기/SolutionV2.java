class SolutionV2 {
    public String solution(String phone_number) {
        int n = phone_number.length();
        return "*".repeat(n - 4) + phone_number.substring(n - 4);
        /*
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i < n - 4) {
                sb.append("*");
                continue;
            }
            sb.append(phone_number.charAt(i));
        }
        return sb.toString();
        */
    }

}