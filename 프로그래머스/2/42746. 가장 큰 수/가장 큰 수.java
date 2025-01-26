/*
주어진 숫자들을 조합해서 만들 수 있는 가장 큰 수 리턴
*/

import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(final int[] numbers) {
    
        List<String> stringNumbers = Arrays.stream(numbers)
            .boxed()
            .map(String::valueOf)
            .collect(Collectors.toList());

        stringNumbers.sort(
            (number1, number2) -> (number2 + number1).compareTo(number1 + number2)
        );


        StringBuilder result = new StringBuilder();
        for (final String number : stringNumbers) {
            result.append(number);
        }
        
        if (stringNumbers.get(0).equals("0")) {
            return "0";
        }

        return result.toString();
    }
}