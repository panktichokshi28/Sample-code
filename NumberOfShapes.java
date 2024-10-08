import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Problem Description:

Write a program that reads a text file that contains 0's and 1's in a regular N x M sized grid.  Here is an example of what a valid input file looks like:

        0110
        0100
        0010
        0011

After reading the file, your goal is to find the number of "connected shapes" in the data.  A connected shape is defined as a group of 1's that are immediately adjacent to each other.  The 1's must be immediately to the left, right, top, or bottom of each other to count as connected (diagonals do not count as connected).

In the example above, your program would return 2, because there are two connected shapes:
        11
        1
at position (0, 1) and
1
        11
at position (2, 2)

You only need to return the number of connected shapes that you've found.  You do not need to return the position of the shapes.

Additional Examples:

Given this data:

        001010
        011011
        001000
        001001
        000000
        000000

Your function would return 3, because there are 3 connected shapes:
        1
        11
        1
        1    at position (0, 2)

1
        11   at position (0, 4)

and

1    at position (3, 5)

----------

Given this data:

        01000
        01000
        11111
        00000
        01100

Your function would return 2, because there are 2 connected shapes:
        1
        1
        11111    at position (0, 1)

and

11       at position (4, 1) */


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

