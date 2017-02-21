// Filename: Bishop.java
//
// Contains the class Bishop that represents a bishop chesspiece
//
// Santrupti Nerli, Jan 2017

class Bishop extends ChessPiece {

  // Default constructor sets loc to infeasible (negative) values
  public Bishop()
  {
    super();
  }

  // Constructor creates Bishop at location (col, row) and color
  public Bishop(int row, int col, boolean color)
  {
    super(row, col, color);
  }

  // Boolean function that determines if self (which is a bishop) is attacking another chesspiece at row and col, given as argument
  // Input: int row and col
  // Output: True if self is attacking the chesspiece at position row and col, false otherwise
  public boolean isAttacking(int row, int col)
  {
      if (Math.abs(this.getRow() - row) == Math.abs(this.getCol() - col)) // if self is on same diagonal as chesspiece, this is attack. we use absolute values to determine diagonal
          return true;
      else
          return false; // self is not attacking chesspiece at position l
  }
  
     //Stores potential places the piece will cross in a 2d array
  //input: col, row of the space the piece wants to move to
  //output: an array [column](top) [row] (bottom) of spaces the pieces will pass
    public int[][] spacesTraversed(int c, int r,int boardSize){
      int[][] moves=new int[2][boardSize];
      //int for indexing of array
      int inc=0;
      int inc2=0;
      //up left diagonal
      if (r > this.getRow() && c < this.getCol() ){
          for (int i=this.getCol()-1;i>c;i--){
            moves[0][inc]= i;
            inc++;
          }          
          for(int j=this.getRow()+1;j<r;j++){
            moves[1][inc2]= j;
            inc2++;
          }
     }
     //down right diagonal 
       if (r < this.getRow() && c > this.getCol() ){
          for (int i=this.getCol()+1;i<c;i++){
            moves[0][inc]= i;
            inc++;
          }          
          for(int j=this.getRow()-1;j>r;j--){
            moves[1][inc2]= j;
            inc2++;
          }
     }
     
     //up right diagonal
       if (r > this.getRow() && c > this.getCol() ){
          for (int i=this.getCol()+1;i<c;i++){
            moves[0][inc]= i;
            inc++;
          }          
          for(int j=this.getRow()+1;j<r;j++){
            moves[1][inc2]= j;
            inc2++;
          }
     } 
       
      //down left diagonal
       if (r < this.getRow() && c < this.getCol() ){
          for (int i=this.getCol()-1;i>c;i--){
            moves[0][inc]= i;
            inc++;
          }          
          for(int j=this.getRow()-1;j>r;j--){
            moves[1][inc2]= j;
            inc2++;
          }
     }    
        
     return moves;
    }
}

// End
