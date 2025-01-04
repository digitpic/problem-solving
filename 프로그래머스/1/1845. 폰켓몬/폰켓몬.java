/*
폰켓몬 N 마리 중, N/2 마리 가져가기

N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
N/2마리의 폰켓몬을 선택하는 방법 중,
가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
그때의 폰켓몬 종류 번호의 개수를 return 하기
*/

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pickNumber = nums.length / 2;
        Set<Integer> elements = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            elements.add(nums[i]);
        }
        int typeNumber = elements.size();
        if (typeNumber >= pickNumber) {
            answer = pickNumber;
        }
        if (typeNumber < pickNumber) {
            answer = typeNumber;
        }
        return answer;
    }
}