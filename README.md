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
