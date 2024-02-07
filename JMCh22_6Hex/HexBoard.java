/**
 * @author getAuthor()
 * @version getDate()
 * @author Period - getPeriod()
 * @author Assignment - JM Ch22.6 - Hex
 * @author Sources - getSources()
 */
public class HexBoard
    extends CharMatrix
{
    public HexBoard(int rows, int cols)
    {
        super(rows, cols);
    }


    public boolean isBlack(int r, int c)
    {

        return charAt(r, c) == 'b';

    }


    public boolean isWhite(int r, int c)
    {

        return charAt(r, c) == 'w';

    }


    public boolean isGray(int r, int c)
    {

        return charAt(r, c) == 'x';

    }


    public void setBlack(int r, int c)
    {

        setCharAt(r, c, 'b');

    }


    public void setWhite(int r, int c)
    {

        setCharAt(r, c, 'w');

    }


    public void setGray(int r, int c)
    {

        setCharAt(r, c, 'x');

    }


    /**
     * Returns true if there is a contiguous chain of black stones that starts
     * in col 0 and ends in the last column of the board; otherwise returns
     * false.
     */
    public boolean blackHasWon()
    {
        boolean bool = false;
        for (int r = 0; r < numRows(); r += 1)
        {
            areaFill(r, 0);
        }

        for (int r = 0; r < numRows(); r += 1)
        {
            // System.out.println("I have been here " + j + " times.");
            if (isGray(r, numCols() - 1))
            {
                bool = true;
                // System.out.println("I have been here " + x + " time.");

            }
        }

        for (int r = 0; r < numRows(); r += 1)
        {
            for (int c = 0; c < numCols(); c += 1)
            {
                if (isGray(r, c))
                {
                    setBlack(r, c);
                }
            }
        }
        // System.out.println("Bool is: " + x);
        return bool;

        /*
         * for (int j = 0; j < numCols(); j++) { boolean bool = areaFill(0, j);
         * if (bool) { return bool; } }
         */
    }


    /**
     * Fills the contiguous area that contains r,c with gray color. Does nothing
     * if r, c is out of bounds or is not black.
     */
    public void areaFill(int r, int c)
    {
        if (isInBounds(r, c) && isBlack(r, c))
        {
            setGray(r, c);

            int[] colNeighbors = { -1, 0, -1, 1, 0, 1 };
            int[] rowNeighbors = { -1, -1, 0, 0, 1, 1 };

            for (int i = 0; i < rowNeighbors.length; i++)
            {
                int neighborCol = colNeighbors[i] + c;
                int neighborRow = rowNeighbors[i] + r;

                areaFill(neighborRow, neighborCol);
            }
        }

        /*
         * if (isBlack(r, c) && isInBounds(r, c)) { setGray(r, c); if (c ==
         * numCols() - 1) { return true; } if (areaFill(r - 1, c - 1)) { return
         * true; } if (areaFill(r - 1, c)) { return true; } if (areaFill(r - 1,
         * c + 1)) { return true; } if (areaFill(r, c - 1)) { return true; } if
         * (areaFill(r, c + 1)) { return true; } } return false;
         */
    }


    public String toString()
    {
        String s = "";

        for (int r = 0; r < numRows(); r++)
        {
            for (int c = 0; c < numCols(); c++)
            {
                if (isBlack(r, c))
                    s += 'B';
                else if (isWhite(r, c))
                    s += 'W';
                else if (isGray(r, c))
                    s += 'X';
                else
                    s += '.';
            }
            s += '\n';
        }
        return s;
    }

    // ****************************************************************


    private boolean isInBounds(int row, int col)
    {
        return row >= 0 && row < numRows() && col >= 0 && col < numCols();
    }
}
