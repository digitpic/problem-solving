class Solution {
    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;
    
    public int solution(final int[][] sizes) {
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        
        // 전체 순회
        for (final int[] card : sizes) {
            // 명함의 가로, 세로 중 더 `긴` 값 찾기
            final int maxLengthInCard = Math.max(card[WIDTH], card[HEIGHT]);
            
            // 가로, 세로 중 더 긴 값을 가로 최댓값으로 지정
            // 명함 전부 눕혀버리기
            maxWidth = Math.max(maxWidth, maxLengthInCard);
            
            // 명함의 가로, 세로 중 더 `짧은` 값 찾기
            final int minLengthInCard = Math.min(card[WIDTH], card[HEIGHT]);
            
            // 가로, 세로 중 더 짧은 값을 세로 최댓값으로 지정?
            // 명함 전부 눕혀버리기
            maxHeight = Math.max(maxHeight, minLengthInCard);
        }
        
        // 최소 지갑 크기 리턴
        return maxWidth * maxHeight;
    }
}