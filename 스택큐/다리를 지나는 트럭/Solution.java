import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new ArrayDeque<>();  // 기존에 트럭 담아 놓는 큐에서 -> 다리 위에 있는 트럭 개수 큐로 변경
        int totalWeightOnBridge = 0;
        int time = 0;

        for (int truckWeight : truck_weights) {
            while (true) {
                if (bridgeQueue.isEmpty()) {    // 다리가 완전히 비어있는 경우, 최초 1회 실행
                    bridgeQueue.offer(truckWeight);
                    totalWeightOnBridge += truckWeight;
                    time++;
                    break;
                }
                if (bridgeQueue.size() == bridge_length) {  // 다리가 가득 차있는 경우
                    totalWeightOnBridge -= bridgeQueue.poll();
                }
                if (totalWeightOnBridge + truckWeight <= weight) { // 다리에 공간이 있고, 최대 무게보다 적게 나가는 경우
                    bridgeQueue.offer(truckWeight);
                    totalWeightOnBridge += truckWeight;
                    time++;
                    break;
                } else {    // 공간은 있으나, 다리 하중의 무게가 초과일 경우
                    bridgeQueue.offer(0);   // 다리 길이만큼  차량 진행 확인
                    time++; // 시간의 흐름을 위해 추가 (어찌됐든 다리 길이만큼 앞에 진입한 차가 지나가고 있음)
                }
            }
        }
        return time + bridge_length;
    }

}
