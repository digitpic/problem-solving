package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

    public static String solution(String cryptogram) {
        String cleanedCryptogram = removeAllDuplicationFrom(cryptogram);

        return cleanedCryptogram;
    }

    public static String removeAllDuplicationFrom(String cryptogram) {
        String cleanedCryptogram = "";

        while (true) {
            cleanedCryptogram = removeOneDuplicationFrom(cryptogram);

            if (cleanedCryptogram.equals(cryptogram)){
                break;
            }

            cryptogram = cleanedCryptogram;
        }

        return cleanedCryptogram;
    }

    public static String removeOneDuplicationFrom(String cryptogram) {
        int length = cryptogram.length();

        if (length == 0){
            return "";
        }

        Deque<Character> dq = new ArrayDeque<>();
        dq.addLast(cryptogram.charAt(0));

        Character prev = cryptogram.charAt(0);

        for (int i=1; i < length; i++) {
            Character curr = cryptogram.charAt(i);

            if (prev == curr){
                if (dq.peekLast() == curr) {
                    dq.removeLast();
                }
            } else {
                dq.addLast(curr);
            }

            prev = curr;
        }


        String result = "";
        while (!dq.isEmpty()){
            result += dq.removeFirst();
        }

        return result;

    }
}