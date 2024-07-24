package onboarding;

import java.util.HashMap;
import java.util.Map;

// 4번 문제 클래스
public class Problem4 {

    // 문제 풀이 메인 메서드
    public static String solution(String word) {

        // word를 반대로 변환한 결과를 담을 변수
        String answer = "";

        // 청개구리 딕셔너리 생성
        Map<Character, Character> convertDict = makeConvertDict();

        // 하나씩 반복
        for (char c : word.toCharArray()) {

            // 청개구리 딕셔너리에 해당 문자가 있는 경우
            if (convertDict.get(c) != null){
                // 변환된 문자를 정답에 추가
                answer += convertDict.get(c);

            }
            // 청개구리 딕셔너리에 해당 문자가 없는 경우
            else {
                // 그대로 정답에 추가
                answer += c;
            }
        }
        return answer;
    }

    // 청개구리 딕셔너리 생성 메서드
    public static Map<Character, Character> makeConvertDict(){
        Map<Character, Character> convertDict;

        // 대문자 청개구리 딕셔너리 생성 (A -> Z, Z -> A)
        Map<Character, Character> uppercaseConvertDict = matchAsciiBetween(65, 90);

        // 소문자 청개구리 딕셔너리 생성 (a -> z, z -> a)
        Map<Character, Character> lowercaseConvertDict = matchAsciiBetween(97, 122);

        // 대문자, 소문자 청개구리 딕셔너리 합치기
        uppercaseConvertDict.putAll(lowercaseConvertDict);

        // 청개구리 딕셔너리 설정
        convertDict = uppercaseConvertDict;

        // 청개구리 딕셔너리 반환
        return convertDict;
    }

    public static Map<Character, Character> matchAsciiBetween(int startAscii, int endAscii){
        Map<Character, Character> convertDict = new HashMap<>();

        // 알파벳 개수 26개만큼 반복
        for (int i = 0; i < 26; i++) {
            // 시작 알파벳
            Character startAlpha = (char)startAscii;

            // 끝 알파벳
            Character endAlpha = (char)endAscii;

            // A -> Z mapping
            convertDict.put(startAlpha, endAlpha);

            // Z -> A mapping
            convertDict.put(endAlpha, startAlpha);

            // 다음 알파벳으로 이동
            startAscii += 1;
            endAscii -= 1;
        }

        // 청개구리 딕셔너리 반환
        return convertDict;
    }
}