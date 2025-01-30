/*
1번: 1, 2, 3, 4, 5 반복
2번: 2, 1, 2, 3, 2, 4, 2, 5 반복
3번: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복

정답이 담긴 answers 배열
가장 많이 맞춘 사람 리턴

동점자의 경우, 오름차순 정렬해 리턴
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int[] solution(final int[] answers) {
        final int length = answers.length;
        
        List<Integer> first = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> second = new ArrayList<>(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        List<Integer> third = new ArrayList<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        
        setup(first, second, third);
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < length; i++) {
            if (first.get(i) == answers[i]) {
                count.put(1, count.getOrDefault(1, 0) + 1);
            }
            
            if (second.get(i) == answers[i]) {
                count.put(2, count.getOrDefault(2, 0) + 1);
            }
            
            if (third.get(i) == answers[i]) {
                count.put(3, count.getOrDefault(3, 0) + 1);
            }
        }
        
        List<Integer> winners = new ArrayList<>();
        
        int maxCount = Collections.max(count.values());

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == maxCount) {
                winners.add(entry.getKey());
            }
        }
        
        return winners.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
    
    private void setup(List<Integer> first, List<Integer> second, List<Integer> third) {
        while (first.size() < 10_000) {
            first.addAll(first);
        }
        
        while (second.size() < 10_000) {
            second.addAll(second);
        }
        
        while (third.size() < 10_000) {
            third.addAll(third);
        }
    }
}