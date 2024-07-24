package onboarding;

import java.util.*;
import java.util.Collections;

// 6번 문제 클래스
public class Problem6 {

    // 문제 풀이 메인 메서드
    public static List<String> solution(List<List<String>> forms) {

        // 정답을 담을 변수
        List<String> answer;

        // 중복이 있는 메일 주소 반환
        answer = findDuplicatedEmailAddresses(forms);

        // 메일을 사전 순으로 정렬
        Collections.sort(answer);

        // 정답 반환
        return answer;
    }

    // 중복이 있는 메일 주소 반환 메서드
    public static List<String> findDuplicatedEmailAddresses(List<List<String>> forms) {
        Map<String, HashSet<String>> matchedAddressesHash = new HashMap<>();
        Set<String> duplicatedEmailAddresses = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String subStr = nickname.substring(i, i + 2);

                HashSet<String> matchedEmailAddresses = matchedAddressesHash.getOrDefault(subStr, new HashSet<>());
                matchedEmailAddresses.add(email);

                // 이 두글자 조합이 들어간 닉네임을 가진 사람들의 수가 2명 인 경우
                if (matchedEmailAddresses.size() == 2) {

                    // 저장된 모든 이메일 추가
                    duplicatedEmailAddresses.addAll(matchedEmailAddresses);
                }

                // 이 두글자 조합이 들어간 닉네임을 가진 사람들의 수가 2명 이상인 경우
                else if (matchedEmailAddresses.size() > 2) {

                    // 현재 이메일 한 개 만 추가
                    duplicatedEmailAddresses.add(email);
                }

                matchedAddressesHash.put(subStr, matchedEmailAddresses);
            }
        }

        return new ArrayList<>(duplicatedEmailAddresses);
    }

}