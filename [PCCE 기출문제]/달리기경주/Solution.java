import java.util.*;
import java.util.stream.Stream;

public class Solution {

    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> playerIndex = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }

        for (String player : callings) {
            int currentIndex = playerIndex.get(player);
            int prevIndex = currentIndex - 1;

            String prevPlayer = players[prevIndex];

            players[prevIndex] = player;
            players[currentIndex] = prevPlayer;

            playerIndex.put(prevPlayer, currentIndex);
            playerIndex.put(player, prevIndex);
        }



        return players;
    }

}

