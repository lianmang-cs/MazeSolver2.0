/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeSolver
{
    private Maze maze;
    private int breadcrumbs = 0; //store the number of breadcrumbs.
    private int called = 0; //store the number of times maze solver is called.
    private static final char START = 'R';
    private static final char END = 'C';

    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse(int row, int column)
    {
        boolean done = false;
        called++; //increments the number of times the maze solver's traverse method is called.
        if (maze.validPosition(row, column))
        {
            System.out.println("The rat is at " + row + ", " + column + ".");
            maze.tryPosition(row, column);   // mark this cell as tried
            breadcrumbs++; //increments the bread crumb if the position is valid.
            if (row == maze.getRows()-1 && column == maze.getColumns()-1)
                done = true;  // the maze is solved
            else
            {
                done = traverse(row+1, column);      // down
                if (!done)
                    done = traverse(row, column+1);  // right

                if (!done)
                    done = traverse(row-1, column);  // up
                if (!done)
                    done = traverse(row, column-1);  // left
            }

            if (done)
            {
                maze.markPath(row, column);
            }
             else {
                 breadcrumbs--; //removes the breadcrumb if it's not the right path.
            }

        }

        return done;
    }
}