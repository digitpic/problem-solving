/*
특정 과학자가 발표한 논문 n 편 중,
h 번 이상 인용된 논문이 h 편 이상이며,
나머지 논문이 h 번 이하 인용 되는 경우에서
h 의 최댓값을 해당 과학자의 H-Index 라고 한다

citations: 특정 과학자가 발표한 논문의 인용 횟수 정보
해당 과학자의 H-Index 를 리턴
*/

import java.util.*;

class Solution {
    public int solution(final int[] citations) {
        int result = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        // 0, 1, 3, 5, 6
        
        for (int i = 0; i < n; i++) {
            // 인용 횟수
            int h = citations[i]; 
            
            // 남은 논문의 개수 (현재 인덱스의 인용 횟수와 같거나, 더 큰 인용 횟수를 가진다)
            int remaining = n - i;
            
            // h 번 이상 인용된 논문이 h 편 이상인 경우
            // 나머지 논문이 h 번 이하 인용 되는 경우
            // h 가 최대인 경우
            if (h >= remaining) {
                return remaining;
            }
        }
        
        return 0;
    }
}