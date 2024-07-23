package onboarding;

// 2번 문제 클래스
public class Problem2 {

    // 문제 풀이 메인 메서드
    public static String solution(String crypto){

        // 암호문에서 중복된 문자 찾아서 계속 제거하기
        while (true){

            // 중복된 문자를 찾아서 제거
            String removed = removeDuplicatedChar(crypto);

            // 중복된 문자가 더 이상 없는 경우
            if (removed.equals(crypto)){
                break; // 반복문 종료
            }

            // 중복된 문자가 있는 경우
            crypto = removed; // 암호문 갱신
        }
        return crypto;
    }

}
