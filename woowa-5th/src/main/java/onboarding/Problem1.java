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

    // 1. 페이지 정보 오류 검증
    public static boolean checkPagesAbnormality(List<Integer> pages){
        // 각 페이지에 대한 정보 뽑기
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 페이지 정보가 1부터 400까지의 범위를 벗어나는 경우
        if (leftPage < 0 || 400 < rightPage){
            return true; // 예외 발생
        }

        // 좌측 페이지에 +1 한 값이 우측 페이지와 같지 않은 경우
        if (leftPage + 1 != rightPage) {
            return true; // 예외 발생
        }

        return false; // 예외가 발생하지 않음
    }

    // 2. 뽑은 페이지에 대한 연산 결과 중 각각의 최댓값
    public static int findMaxBetweenPages(List<Integer> pages){
        // 좌측 페이지에 대한 최대 수 찾기
        int leftMax = findMaxBetweenSumAndMulti(pages.get(0));

        // 우측 페이지에 대한 최대 수 찾기
        int rightMax = findMaxBetweenSumAndMulti(pages.get(1));

        // 두 수 중 최댓값 찾기
        int result = (leftMax < rightMax) ? rightMax : leftMax;

        // 최댓값 반환
        return result;
    }

}