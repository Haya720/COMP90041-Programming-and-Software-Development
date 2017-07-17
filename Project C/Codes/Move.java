/**
 * Project C of COMP90041
 * 
 * @author Name: Hongyao Wei, Student ID: 741027
 */
public class Move {
	// ======================== Variables ===========================
	private int moveRow, moveCol;

	// ======================== Functions ==========================
	// constructor
	public Move(int row, int col)
	{
		this.moveRow = row;
		this.moveCol = col;
	}
	
	/**
	 * @return the moveRow
	 */
	public int getMoveRow() {
		return moveRow;
	}

	/**
	 * @param moveRow the moveRow to set
	 */
	public void setMoveRow(int moveRow) {
		this.moveRow = moveRow;
	}

	/**
	 * @return the moveCol
	 */
	public int getMoveCol() {
		return moveCol;
	}

	/**
	 * @param moveCol the moveCol to set
	 */
	public void setMoveCol(int moveCol) {
		this.moveCol = moveCol;
	}
	
	
}
