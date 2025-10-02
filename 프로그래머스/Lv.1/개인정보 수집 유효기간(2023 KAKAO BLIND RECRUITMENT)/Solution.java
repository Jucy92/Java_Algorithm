import java.util.*;

class Solution {
    Map<String, Integer> termMap = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        int todayDays = convertToDay(today);
        for (String term : terms) {
            String[] termParts = term.split(" ");
            termMap.put(termParts[0], Integer.parseInt(termParts[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            String privacyDate = privacyParts[0];
            String privacyRank = privacyParts[1];

            int expirationDays = calculateExpiration(privacyDate, termMap.get(privacyRank));

            if (todayDays >= expirationDays) {
                result.add(i + 1);
            }


        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private int convertToDay(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // 2000년도 기준 / month - 1 하는 이유는 1,2월 넣어보셈 일수가 -1 없을경우 달라짐
        return (year - 2000) * 12 * 28 + (month -1) * 28 + day;
    }
    private int calculateExpiration(String expireDate, int validMonths) {
        String[] parts = expireDate.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        month += validMonths;

        while (month > 12) {   // 12보다 크니깐 13부터겠지? 그리고.. 12개월이 아니라 24개월 36개월 일 수도 있으니..
            year += 1;
            month -= 12;
        }
        String expirationDate = String.format("%d.%02d.%02d", year, month, day);
        return convertToDay(expirationDate);
    }
}