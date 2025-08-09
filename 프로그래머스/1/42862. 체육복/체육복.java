class Solution {
    private static final int MAX = 30;
    
    private static int[] people = new int[MAX];
    private static int answer;
        
    public int solution(int n, int[] lost, int[] reserve) {
        answer = n;
        
        for (int l : lost) {
            people[l - 1]--;
        }
            
        for (int r : reserve) {
            people[r - 1]++;
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) {
                if (0 < i && people[i - 1] == 1) {
                    people[i]++;
                    people[i - 1]--;
                } else if (i + 1 < n && people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}