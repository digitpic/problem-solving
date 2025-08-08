import java.util.*;

class Solution {
    
    public boolean solution(String s) {
        int size = s.length();
        
        try {
            Integer.parseInt(s);
            if (size != 4 && size != 6) {
                return false;    
            }
        } catch (NumberFormatException e) {
            return false;
        }
    
        return true;
    }
    
}