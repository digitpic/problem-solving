/*
매일 다른 옷 조합.

전 날보다 추가 되거나,
전 날 아이템이 전부 동일하지 않아야 함.

종류별 최대 1가지,
최소 한 개의 의상.

clothes: [이름, 종류]
*/

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private static final int NAME_INDEX = 0;
    private static final int TYPE_INDEX = 1;
    
    public int solution(final String[][] clothes) {
        // type, names
        Map<String, List<String>> data = new HashMap<>();
        
        for (final String[] element : clothes) {
            List<String> names = new ArrayList<>();
            
            String name = element[NAME_INDEX];
            String type = element[TYPE_INDEX];
            
            if (data.containsKey(type)) {
                names = data.get(type);
                names.add(name);
            }
            
            if (!data.containsKey(type)) {
                names.add(name);    
            }
            
            data.put(type, names);
        }
        
        Set<String> keys = new HashSet<>(data.keySet());
        
        int count = 1;
        for (final String key : keys) {
            List<String> values = data.get(key);
            count *= values.size() + 1; // r=1, nCr == n
        }
    
        return count - 1;
    }
}