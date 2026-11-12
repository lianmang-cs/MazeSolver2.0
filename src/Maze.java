/*
Name: Lian Mang
Date: 11/18/24
Class: CSC 1120
Description: The class is the foundation of the maze solver, as it is the maze itself. The
constructor of the maze, creates the grid of the maze with a nested for loop, one loop for
the row and the other for the column. Some methods of the class are accessor for the position,
and others are mutators used to update the maze.
 */
import java.util.*;
import java.io.*;

/**
 * Maze represents a maze of characters. The goal is to get from the
 * top left corner to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 */
public class Maze
{
    private static final char TRIED = '.';
    private static final char PATH = 'o';
    private static final char WALL = '#';
    private static final char START = 'R';
    private static final char END = 'C';

    private int numberRows, numberColumns;
    private int[][] grid;

    /**
     * Constructor for the Maze class. Loads a maze from the given file.
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();


        grid = new int[numberRows][numberColumns];
        for (int i = 0; i < numberRows; i++)
            for (int j = 0; j < numberColumns; j++)
                grid[i][j] = scan.nextInt();
    }

    /**
     * Marks the specified position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try
     */
    public void tryPosition(int row, int col)
    {
        grid[row][col] = TRIED;
    }
    /**
     * Return the number of rows in this maze
     *
     * @return the number of rows in this maze
     */
    public int getRows()
    {
        return grid.length;
    }

    /**
     * Return the number of columns in this maze
     *
     * @return the number of columns in this maze
     */
    public int getColumns()
    {
        return grid[0].length;
    }

    /**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col)
    {
        grid[row][col] = PATH;
    }
    //Method for the end of the path. To check if it has ended.
    public boolean isEnd(int row, int col)
    {
        //return true if the row and column contains the END char  ('C').
        return grid[row][col] == END;
    }
    /**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid
     */
    public boolean validPosition(int row, int column)
    {
        boolean result = false;

        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length &&
                column >= 0 && column < grid[row].length)

            //  check if cell is not blocked (WALL) and not previously tried
            if (grid[row][column] != WALL && grid[row][column] != TRIED)
                result = true; //is valid position

        return result; // is invalid position 
    }
    /**
     * Returns the maze as a string.
     *
     * @return a string representation of the maze
     */
    public String toString()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }

        return result;
    }
}