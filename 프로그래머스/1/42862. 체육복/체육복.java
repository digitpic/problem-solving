class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;
        
        // 초기 세팅
        for (int l : lost) {
            int lostIndex = l - 1;
            people[lostIndex]--;
        }
            
        for (int r : reserve) {
            int reserveIndex = r - 1;
            people[reserveIndex]++;
        }

        for (int i = 0; i < people.length; i++) {
            // i 번 학생이 체육복을 도난 당했다면
            if (people[i] == -1) {
                
                // i - 1 번 학생이 여분이 있다면
                if (i > 0 && people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                } 
                
                // i + 1 번 학생이 여분이 있다면
                else if (i + 1 < n && people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                }
                
                // i - 1, i + 1 번 학생 둘 다 여분이 없다면
                else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}