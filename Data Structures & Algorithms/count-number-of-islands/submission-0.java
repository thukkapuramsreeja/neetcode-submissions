class Solution {

    public int numIslands(char[][] grid) {

        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    islands++;
                    explore(grid, i, j);
                }
            }
        }

        return islands;
    }

    private void explore(char[][] grid, int row, int col) {

        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';

        explore(grid, row + 1, col);
        explore(grid, row - 1, col);
        explore(grid, row, col + 1);
        explore(grid, row, col - 1);
    }
}