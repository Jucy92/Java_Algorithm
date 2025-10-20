import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int  n = score.length;
        int[] answer = new int[n];;
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i = 0; i< n; i++){

            if(!que.isEmpty() && (k <= que.size()) ){
                if(que.size() == k && que.peek()<score[i]){
                    que.poll();
                    que.add(score[i]);
                }
            }else{
                que.add(score[i]);
            }

            answer[i] = que.peek();
        }
        return answer;
    }
}