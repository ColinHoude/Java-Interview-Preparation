public class Main {
    public static void main(String[] args) {
        //Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
        //An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
        // You may assume all four edges of the grid are all surrounded by water.
        // DEPTH FIRST SEARCH
        int[][] input = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int[][] input2 = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        numIslands(input);
        numIslands(input2);
    }

    public static void numIslands(int[][] grid){
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    numIslands++;
                    clearGrid(grid, i, j);
                }
            }
        }
        System.out.println(numIslands);
    }

    public static void clearGrid(int[][] grid, int i, int j){
        // this function is pretty cool
        // when an island is found
        // it clears the whole island until:
            // there is no more island left -- all values adjacent to it are 0
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        clearGrid(grid, i+1, j);
        clearGrid(grid, i, j+1);
        clearGrid(grid, i-1, j);
        clearGrid(grid, i, j-1);
    }
}