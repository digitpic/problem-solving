package onboarding;

import java.util.ArrayList;
import java.util.List;

// 5번 문제 클래스
public class Problem5 {

    // 문제 풀이 메인 메서드
    public static List<Integer> solution(int money) {

        // 정답을 담을 리스트
        List<Integer> answer = new ArrayList<>();

        // 돈 종류
        List<Integer> moneyTypes = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        // 큰 돈 부터 나눠가면서 몫을 구해가면 된다.
        for (int moneyType : moneyTypes) {

            // 몫을 구하고
            int quotient = money / moneyType;

            // 몫을 정답 리스트에 추가
            answer.add(quotient);

            // 나머지를 다음 돈 종류로 넘긴다.
            money %= moneyType;
        }

        // 정답 반환
        return answer;
    }
}