public class Main {
    static int sum = 0;
    public static void main(String[] args) {
        //Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
        //An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
        // You may assume all four edges of the grid are all surrounded by water.
        // DEPTH FIRST SEARCH
        int[][] input = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        maxArea(input);
    }

    public static void maxArea(int[][] grid){
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    sum = 0;
                    clearGrid(grid, i, j);
                    maxArea = Math.max(sum, maxArea);
                }
            }
        }
        System.out.println(maxArea);
    }

    public static void clearGrid(int[][] grid, int i, int j){
        // this function is pretty cool
        // when an island is found
        // it clears the whole island until:
        // there is no more island left -- all values adjacent to it are 0
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        sum++;
        clearGrid(grid, i+1, j);
        clearGrid(grid, i, j+1);
        clearGrid(grid, i-1, j);
        clearGrid(grid, i, j-1);
    }
}