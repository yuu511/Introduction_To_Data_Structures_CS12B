// Filename: Rook.java
//
// Contains the class Rook that represents a rook chesspiece
//
// Santrupti Nerli, Jan 2017

class Rook extends ChessPiece {

  // Default constructor sets loc to infeasible (negative) values
  public Rook()
  {
    super();
  }

  // Constructor creates Rook with row, col and color
  public Rook(int row, int col, boolean color)
  {
    super(row, col, color);
  }

  // Boolean function that determines if self (which is a rook) is attacking another chesspiece at location row, col, given as argument
  // Input: integer row and col
  // Output: True if self is attacking the chesspiece at position (row, col), false otherwise
  public boolean isAttacking(int row, int col)
  {
      if (this.getRow() == row || this.getCol() == col) // if self has same row or column as chesspiece, self is attacking
          return true;
      else
          return false; // self is not attacking chesspiece
  }
  
   //Stores potential places the piece will cross in a 2d array
  //input: col, row of the space the piece wants to move to
  //output: an array [column](top) [row] (bottom) of spaces the pieces will pass
    public int[][] spacesTraversed(int c, int r,int boardSize){
      int[][] moves=new int[2][boardSize];
      //int for indexing of array
      int inc=0;
      //if rook is moving by increasing row,
      if (r > this.getRow() && c==this.getCol() ){
        for (int i=this.getRow()+1;i<r;i++){          
          moves[0][inc]=this.getCol();
          moves[1][inc]=i;
          inc++;
        }
      }
      //if rook is moving by increasing col,
       if (r ==this.getRow() && c > this.getCol() ){
        for (int i=this.getCol()+1;i<c;i++){          
          moves[0][inc]=i;
          moves[1][inc]=this.getRow();
          inc++;
        }
      }
      
     //if rook is moving by decreasing row,
      if (r < this.getRow() && c==this.getCol() ){
        for (int i=this.getRow()-1;i>r;i--){          
          moves[0][inc]=this.getCol();
          moves[1][inc]=i;
          inc++;
        }
      }
      
      //if rook is moving by decreasing col,
       if (r ==this.getRow() && c < this.getCol() ){
        for (int i=this.getCol()-1;i>c;i--){          
          moves[0][inc]=i;
          moves[1][inc]=this.getRow();
          inc++;
        }
      }
       
      
      return moves;
    }

  
}

// End
