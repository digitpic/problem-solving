package onboarding;

import java.util.List;

// 1번 문제 클래스
public class Problem1 {

    // 문제 풀이 메인 메서드
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 정답을 담을 변수
        int answer;

        // 예외 처리
        try {

            // 1. 페이지 정보 오류 검증
            // 페이지 정보가 예외에 해당하는 경우
            if (checkPagesAbnormality(pobi) || checkPagesAbnormality(crong)) {
                return -1; // 예외 발생
            }

            // 2. 뽑은 페이지에 대한 연산 결과 중 각각의 최댓값 설정
            int pobiMax = findMaxBetweenPages(pobi);
            int crongMax = findMaxBetweenPages(crong);

            // 3. 연산 결과를 바탕으로 승자를 정답 변수에 저장
            answer = checkWinner(pobiMax, crongMax);

        } catch (Exception e) {
            return -1; // 예외 발생
        }

        // 정답 반환
        return answer;
    }

}