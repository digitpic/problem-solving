/*
arr 안에 들어갈 숫자는 0 ~ 9
연속적으로 나타나는 숫자는 하나만 남긴다
*/

import java.util.LinkedList;

public class Solution {
    public int[] solution(final int []arr) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        for (final int number : arr) {
            if (linkedList.isEmpty() || linkedList.getLast() != number) {
                linkedList.add(number);
            }
        }
        
        return linkedList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}