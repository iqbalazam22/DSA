class Solution {
    public void recur(int[][] image, int i, int j, int color, int gCol){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length) return;

        if(image[i][j] != gCol) return;

        image[i][j] = color;

        recur(image, i+1, j, color, gCol);
        recur(image, i-1, j, color, gCol);
        recur(image, i, j+1, color, gCol);
        recur(image, i, j-1, color, gCol);

        return;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int colour = image[sr][sc];
        if(colour != color){
            recur(image, sr, sc, color, colour);
        }
        return image;
    }
}