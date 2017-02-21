// Filename: King.java
//
// Contains the class King that represents a king chesspiece
//
// Santrupti Nerli, Jan 2016

class King extends ChessPiece {

    // Default constructor sets row and col to infeasible (negative) values
    public King()
    {
        super();
    }

    // Constructor creates King with given row, col and color
    public King(int row, int col, boolean color)
    {
        super(row, col, color);
    }

    // Boolean function that determines if self (which is a king) is attacking another chesspiece, given as argument
    // Input: integer row, col
    // Output: True if self is attacking chesspiece at location (row, col), false otherwise
    public boolean isAttacking(int row, int col)
    {
        int attackRow[] = {-1, -1, 0, 1, 0, 1, 1, -1}; // possible attack row positions
        int attackCol[] = {0, -1, -1, -1, 1, 1, 0, 1}; // possible attack col positions

        for(int i = 0; i < 8; i++) {
          if(this.getRow() + attackRow[i] == row && this.getCol() + attackCol[i] == col) {
            return true;
          }
        }
        return false;
    }
    
    //returns a 2d array of the space around a king
    //used for checkmate calculation
    //col, row of spaces
    public int[][] bufferZone(int boardSize){
      int attackRow[] = {-1, -1, 0, 1, 0, 1, 1, -1}; // possible buffer zone positions
      int attackCol[] = {0, -1, -1, -1, 1, 1, 0, 1}; // possible buffer zone positions
      int possibleSpaces[][]=new int [2][8];
      for (int i=0;i<8;i++){
        if (((this.getCol()+attackCol[i]>=0)&&(this.getCol()+attackCol[i]<=boardSize))&&
        ((this.getRow()+attackRow[i]>=0)&&(this.getRow()+attackRow[i]<=boardSize))){
         possibleSpaces[0][i]=this.getCol()+attackCol[i];
         possibleSpaces[1][i]=this.getRow()+attackRow[i];
        }
      }
      return possibleSpaces;
    }
    
    //The program is structured in a way that ensures that:
   //a. the attempted move does not involve a piece of the same color on that space
   //b. if the piece does move the the spot and there is a piece of a different color, it will remove that piece first
   //So there is no need for an actual method to check for blocking in other spaces because 
  //the king will move one unit only,meaning no blank space.
    public int[][] spacesTraversed(int c, int r,int boardSize){
      int[][] moves=new int[2][boardSize];    
      return moves;
    } 
}

// End
