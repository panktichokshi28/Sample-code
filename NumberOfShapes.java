import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfShapes {
    public static void main(String[] args) throws IOException {
        //input file
        String file = "C:\\Users\\akash\\Downloads\\data_large.txt";
        //read from file and convert into char 2d array
        char[][] grid = readFromFile(file);
        // count number of shapes
        int numberOfShapes = connectedShapes(grid);
        System.out.println("Number of Shapes:" + numberOfShapes);

    }

    private static int connectedShapes(char[][] grid) {
        //count connected shapes
        int n = grid.length;
        int m = grid[0].length;
        int shapeCounts = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    //dfs call
                    if (dfs(i, j, grid, m, n)) {
                        shapeCounts++;
                    }
                }
            }

        }
        return shapeCounts;
    }

    private static char[][] readFromFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int row = 0;
        String line;
        int col = 0;
        //iterate through file and count number of rows and columns
        while ((line = br.readLine()) != null) {
            row++;
            col = line.length();
        }

        char[][] grid = new char[row][col];
        br = new BufferedReader((new FileReader(file)));
        int rw = 0;
        while ((line = br.readLine()) != null) {
            for (int column = 0; column < line.length(); column++) {
                grid[rw][column] = line.charAt(column);
            }
            rw++;
        }
        br.close();
        return grid;
    }

    //dfs method to mark connected 1's
    public static boolean dfs(int i, int j, char[][] grid, int m, int n) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return false;
        grid[i][j] = '0';
        //dfs recursive call
        dfs(i + 1, j, grid, m, n);
        dfs(i - 1, j, grid, m, n);
        dfs(i, j + 1, grid, m, n);
        dfs(i, j - 1, grid, m, n);
        return true;
    }
}

