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
        Arrays.sort(citations);

        int n = citations.length;
            
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}