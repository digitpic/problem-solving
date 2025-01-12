/*
priorities 가 주어질 때, 차례대로 A..n 프로세스라고 한다.
location 이 주어줄 때, 해당 프로세스가 몇 번째에 실행되는지를 리턴한다.

큐에서 프로세스 하나씩 꺼낸다.
큐에 우선순위가 더 높은 프로세스가 있다면 꺼낸 프로세스를 다시 넣는다.
우선순위가 더 높은 프로세스가 없다면 꺼낸 프로세스를 실행하며, 해당 프로세스를 종료시킨다.
*/

import java.util.*;

class Solution {
    private static final int PRIORITY_INDEX = 0;
    private static final int INITIAL_STATE_INDEX = 1;
    
    public int solution(final int[] priorities, final int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] { priorities[i], i });
        }

        int count = 0;

        // 큐가 비워질 때까지 반복
        while (!queue.isEmpty()) {
            // 프로세스 하나 꺼내기
            int[] current = queue.poll(); 
            boolean hasHigher = false;

            // 큐에 더 높은 우선순위를 가진 프로세스가 있는지 확인
            for (int[] process : queue) {
                // 있다면 
                if (process[PRIORITY_INDEX] > current[PRIORITY_INDEX]) {
                    hasHigher = true;
                    // 해당 프로세스를 마지막에 다시 추가
                    queue.add(current);
                    break;
                }
            }

            // 없다면
            if (!hasHigher) {
                // 해당 프로세스를 실행
                count++;
                
                // 해당 프로세스가 location 값이면 종료
                if (current[INITIAL_STATE_INDEX] == location) {
                    return count;
                }
            }
        }

        return count;
    }
}