import java.util.*;

public class Solution {

    public int solution(String[] friends, String[] gifts) {
        int nextMonthGiftCount = 0;
        Map<String, Integer> nextMonthGiftMap = new HashMap<>();

        Map<String, Friend> friendsMap = new HashMap<>();

        for (String friendName : friends) {
            friendsMap.put(friendName, new Friend(friendName));
        }
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            friendsMap.get(giver).giveGift(receiver);
            friendsMap.get(receiver).receiveGift(giver);
        }
        for (String friendName : friends) {
            nextMonthGiftMap.put(friendName, 0);
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {

                Friend friend1 = friendsMap.get(friends[i]);
                Friend friend2 = friendsMap.get(friends[j]);

                int f1tof2 = friend1.getGivenToFriend(friend2.name);
                int f2tof1 = friend2.getGivenToFriend(friend1.name);
                if (f1tof2 > f2tof1 ) {
                    // f1 ++
                    nextMonthGiftMap.put(friend1.name, nextMonthGiftMap.getOrDefault(friend1.name, 0) + 1);
                } else if (f1tof2 < f2tof1 ) {
                    nextMonthGiftMap.put(friend2.name, nextMonthGiftMap.getOrDefault(friend2.name, 0) + 1);
                } else {
                    if (friend1.getGiftIndex() > friend2.getGiftIndex()) {
                        nextMonthGiftMap.put(friend1.name, nextMonthGiftMap.get(friend1.name) + 1);
                    } else if (friend2.getGiftIndex() > friend1.getGiftIndex()) {
                        nextMonthGiftMap.put(friend2.name, nextMonthGiftMap.get(friend2.name) + 1);
                    }
                }
            }
        }
        return Collections.max(nextMonthGiftMap.values());
    }

    static class Friend {
        String name;
        int totalGiven;
        int totalReceive;
        Map<String, Integer> giftGiven;
        Map<String, Integer> giftReceived;


        public Friend(String name) {
            this.name = name;
            this.totalGiven = 0;
            this.totalReceive = 0;
            this.giftGiven = new HashMap<>();
            this.giftReceived = new HashMap<>();
        }

        public void giveGift(String receiver) {
            totalGiven++;
            giftGiven.put(receiver, giftGiven.getOrDefault(receiver, 0) + 1);
        }

        public void receiveGift(String giver) {
            totalReceive++;
            giftReceived.put(giver, giftReceived.getOrDefault(giver, 0) + 1);
        }

        public int getGiftIndex() {
            return totalGiven - totalReceive;
        }

        public int getGivenToFriend(String friendName) {
            return giftGiven.getOrDefault(friendName,0);
        }

        public int getTotalReceiveToFriend(String friendName) {
            return giftReceived.getOrDefault(friendName,0);
        }


    }

}

