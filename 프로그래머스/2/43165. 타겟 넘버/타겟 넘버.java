/*
n 개의 음이 아닌 정수
순서를 바꾸지 않고, 적절히 더하거나 빼서 타겟 넘버 만들기

numbers: 사용할 수 있는 숫자가 담긴 배열
target: 타겟 넘버
return: 타겟 넘버를 만드는 방법의 수
*/

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public int dfs(int[] numbers, int target, int sum, int count) {
        // 전부 돌았다면
        if (count == numbers.length) {
            
            // 타겟 넘버가 만들어지면
            if (sum == target) {
                // 경우의 수 추가
                return 1;
            }
            // 만들어지지 않으면 경우의 수 추가하지 않음
            return 0;
        }
        
        // 전부 돌지 않았다면 다음 재귀 호출
        return dfs(numbers, target, sum + numbers[count], count + 1) 
            + dfs(numbers, target, sum - numbers[count], count + 1);
    }
}