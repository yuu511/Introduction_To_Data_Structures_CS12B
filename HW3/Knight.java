// Filename: Knight.java
//
// Contains the class Knight that represents a knight chesspiece
//
// Santrupti Nerli, Jan 2017

class Knight extends ChessPiece {

    // Default constructor sets location to infeasible (negative) values
    public Knight()
    {
      super();
    }

    // Constructor creates Knight with row, col and color
    public Knight(int row, int col, boolean color)
    {
        super(row, col, color);
    }

    // Boolean function that determines if self (which is a knight) is attacking another chesspiece, given as argument
    // Input: integer row, col
    // Output: True if self is attacking chesspiece at location (row, col), false otherwise
    public boolean isAttacking(int row, int col)
    {
        int attackRow[] = {-1, 1, -1, 1, -2, -2, 2, 2}; // possible attack row positions
        int attackCol[] = {-2, -2, 2, 2, -1, 1, -1, 1}; // possible attack col positions

        for(int i = 0; i < 8; i++) {
          if(this.getRow() + attackRow[i] == row && this.getCol() + attackCol[i] == col) {
            return true;
          }
        }
        return false;
    }
     
    //dummy method for knight, which ignores blocking.
    public int[][] spacesTraversed(int c, int r,int boardSize){
      int[][] moves=new int[2][boardSize];    
      return moves;
    } 
}

// End
