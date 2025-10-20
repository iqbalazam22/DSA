class Solution {
    public void recur(int[][] image, int i, int j, int srcC, int color, int m, int n){
        
        if(i < 0 || j < 0 || i >= m || j >= n) return;

        if(image[i][j] != srcC) return;

        image[i][j] = color;

        recur(image, i+1, j, srcC, color, m, n);
        recur(image, i-1, j, srcC, color, m, n);
        recur(image, i, j+1, srcC, color, m, n);
        recur(image, i, j-1, srcC, color, m, n);

        return;

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int srcC = image[sr][sc];

        if(image[sr][sc] != color){
            recur(image, sr, sc, srcC, color, m, n);
        }
        return image;
    }
}