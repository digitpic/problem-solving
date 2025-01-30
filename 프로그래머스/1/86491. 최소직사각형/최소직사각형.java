class Solution {
    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;
    
    public int solution(final int[][] sizes) {
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        
        for (final int[] card : sizes) {
            maxWidth = Math.max(maxWidth, Math.max(card[WIDTH], card[HEIGHT]));
            maxHeight = Math.max(maxHeight, Math.min(card[WIDTH], card[HEIGHT]));
        }
        
        return maxWidth * maxHeight;
    }
}