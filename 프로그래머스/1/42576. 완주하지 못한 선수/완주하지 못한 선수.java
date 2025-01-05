/*
[완주하지 못한 선수]
단 한 명의 선수를 제외하고, 모든 선수는 마라톤을 완주한다.

participant: 마라톤 참여한 선수들 이름
completion: 완주한 선수들 이름

참가자 중 동명이인이 있을 수 있다.
*/

import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> roster = new HashMap<>();
        
        for (String player : participant) {
            roster.put(player, roster.getOrDefault(player, 0) + 1);   
        }
        
        for (String player : completion) {
            roster.put(player, roster.getOrDefault(player, 0) - 1);   
        }

        for (String player : roster.keySet()) {
            if (roster.get(player) != 0){
                answer = player;
            }
        }
        
        return answer;
    }
}