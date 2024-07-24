package onboarding;

// 3번 문제 클래스
public class Problem3 {

    // 문제 풀이 메인 메서드
    public static int solution(int number) {

        // 박수 횟수를 담을 배열
        int[] clapCount = new int[number+1];

        clapCount[0] = 0;

        // 1부터 number까지의 박수 횟수 계산
        for (int i=1; i <= number; i++) {
            clapCount[i] = clapCount[i-1] + calculateClapCount(i);
        }

        return clapCount[number];
    }

    public static int calculateClapCount(int number){
        int count = 0;

        // number가 0이 될 때까지 반복
        while (number != 0) {

            // 가장 오른쪽 수 추출
            int units = number % 10;


            // 3, 6, 9 중 하나인 경우
            if (units == 3 || units == 6 || units == 9) {
                count += 1;
            }

            // 가장 오른쪽 수 제거
            number /= 10;
        }

        return count;
    }
}