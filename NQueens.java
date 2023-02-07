/*
 * Consider an N x N chess board. You wish to place N queens on this board, so that none of them are attacking each other - that is, 
 * so that no two queens are on the same row, same column, or same diagonal as each other. Naturally, this will mean that we only want
 * one queen per row, and so we can represent this by one number per row, indicating the position of this particular queen.
 * 
 * 
 */


public class NQueens {

	private final boolean DEBUG_MODE = true;
	private int[] queenList;
	
	public NQueens(int size)
	{
		queenList = new int[size];
		for (int i=0; i<size; i++)
			queenList[i] = 0;
		if (placeQueenInRow(0))
			displayBoard();
		else
			System.out.println("No solution found.");
	}

	public void debugOut(String s)
	{
		if (DEBUG_MODE)
			System.out.println("DEBUG:\t"+s);
	}

	public boolean placeQueenInRow(int row)
	{
		if (row == queenList.length)
			return true;
		
		debugOut("Placing queen # "+row+" in queenlist: "+toString());
		
		
		for (int col=0; col<queenList.length; col++)
		{
			queenList[row] = col;
			if (noConflictsUpToRow(row))
				if (placeQueenInRow(row+1)) // here's the recursive call....
					return true;
		}
		return false;
	}
	
	public boolean noConflictsUpToRow(int row)
	{
			for (int j=0; j<row; j++)
			{
				if (queenList[row] == queenList[j])
				{	debugOut("\tConflict: | locations "+row+" and "+j+". "+toString());// check for queens on same column
					return false;
				}
				if (queenList[row] == queenList[j]+(j-row)) // check for queens on same diagonal (slope 1)
				{	debugOut("\tConflict: \\ locations "+row+" and "+j+". "+toString());// check for queens on same column
					return false;
				}	
				if (queenList[row] == queenList[j]-(j-row)) // check for queens on same (other) diagonal (slope -1)
				{	debugOut("\tConflict: / locations "+row+" and "+j+". "+toString());// check for queens on same column
					return false;
				}	
			}
		return true;
	}
	
	public void displayBoard()
	{
		for (int i=0; i<queenList.length; i++)
		{
			for (int j=0; j<queenList.length;j++)
				System.out.print("+-");
			System.out.println("+");
			
			for (int j=0; j<queenList.length; j++)
			{
				System.out.print("|");
				if (j==queenList[i])
					System.out.print("Q");
				else
					System.out.print(" ");
			}
			System.out.print("|\n");
		}
		for (int j=0; j<queenList.length;j++)
			System.out.print("+-");
		System.out.println("+");
		
	}

	public String toString()
	{
		String output = "[";
		for (int c:queenList)
			output+=String.format("% 2d", c)+" ";
		output+="]";
		return output;
		
	}
	
}
