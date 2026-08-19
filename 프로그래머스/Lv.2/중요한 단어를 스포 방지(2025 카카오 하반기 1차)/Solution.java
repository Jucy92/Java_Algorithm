import java.util.*;

class Solution {

    public int solution(String message, int[][] spoiler_ranges) {
        int count = 0;

        Map<String, Integer> checkMap = new HashMap<>();
        Set<String> keyword = new HashSet<>();
        int n = message.length();
        boolean[] isMask = new boolean[n];

        for (int[] spoilerRange : spoiler_ranges) {
            for (int i = spoilerRange[0]; i <= spoilerRange[1]; i++) {
                isMask[i] = true;
            }
        }
        List<String> spoilerWords = new ArrayList<>();
        Set<String> nonSpoilerTexts = new HashSet<>();

        int i = 0;
        while (i < n) {
            if (message.charAt(i) == ' ') {i++; continue; }
            int start = i;
            while (i < n && message.charAt(i) != ' ') i++;
            int end = i-1;
            String word = message.substring(start, end + 1);

            boolean isSpoiler = false;
            for (int k = start; k <= end; k++) {
                if (isMask[k]) {
                    isSpoiler = true;
                    break;
                }
            }

            if (isSpoiler) {
                nonSpoilerTexts.add(word);
            } else {
                spoilerWords.add(word);
            }
        }
        System.out.println("nonSpoilerTexts = " + nonSpoilerTexts);
        System.out.println("spoilerWords = " + spoilerWords);
        for (String word : nonSpoilerTexts) {
            if (!spoilerWords.contains(word)) {
                count++;
            }
        }
        return count;
    }
}