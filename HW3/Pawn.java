// Filename: Pawn.java
//
// Contains the class Pawn that represents a pawn chesspiece
//
// Santrupti Nerli, Jan 2017

class Pawn extends ChessPiece {

  // Default constructor sets loc to infeasible (negative) values
  public Pawn()
  {
    super();
  }

  // Constructor creates Pawn with col, row and color
  public Pawn(int row, int col, boolean color)
  {
    super(row, col, color);
  }

  // Boolean function that determines if self (which is a pawn) is attacking another chesspiece at row and col, given as argument
  // Input: int row and col
  // Output: True if self is attacking the chesspiece at position row and col, false otherwise
  public boolean isAttacking(int row, int col)
  {
      int[] attackRow = {0, 0};
      int[] attackCol = {0, 0};

      if(this.getColor() == true) {
        // if it is a white pawn
        // then it advances from bottom to top (unidirectional) in a chessboard
        // attacks only one step diagonals
        attackRow[0] = 1;
        attackRow[1] = 1;
        attackCol[0] = -1;
        attackCol[1] = 1;
      }
      else if(this.getColor() == false) {
        // if it is a black pawn
        // then it advances from top to bottom (unidirectional) in a chessboard
        // attacks only one step diagonals
        attackRow[0] = -1;
        attackRow[1] = -1;
        attackCol[0] = -1;
        attackCol[1] = 1;
      }
      else {
        Utilities.errExit("Invalid color for a pawn");
      }
      for(int i = 0; i < 2; i++) {
        if(this.getRow() + attackRow[i] == row && this.getCol() + attackCol[i] == col) {
          return true;
        }
      }
      return false;
  }
  
    //The program is structured in a way that ensures that:
   //a. the attempted move does not involve a piece of the same color on that space
   //b. if the piece does move the the spot and there is a piece of a different color, it will remove that piece first
   //So there is no need for an actual method to check for blocking in other spaces because 
  //the pawn will move one unit only,meaning no blank space.
    public int[][] spacesTraversed(int c, int r,int boardSize){
      int[][] moves=new int[2][boardSize];    
      return moves;
    }  
}

// End
