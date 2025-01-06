/*
주어진 번호 중, 하나의 번호가 다른 번호의 접두사인 경우 false
접두사가 아닌 경우 true
중복 전화번호 없음
*/

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        return true;
    }
}
