// Filename: Queen.java
//
// Contains the class Queen that represents a queen chesspiece
//
// Santrupti Nerli, Jan 2017

class Queen extends ChessPiece {

    // Default constructor sets row and col to infeasible (negative) values
    public Queen()
    {
        super();
    }

    // Constructor creates Queen with col c and row r
    public Queen(int row, int col, boolean color)
    {
        super(row, col, color);
    }

    // Boolean function that determines if self (which is a queen) is attacking another chesspiece, given as argument
    // Input: integer row and col
    // Output: True if self is attacking another chesspiece at (row, col), false otherwise
    public boolean isAttacking(int row, int col)
    {
        if (this.getRow() == row || this.getCol() == col) // if self has same row or column as chesspiece, self is attacking
            return true;
        else if (Math.abs(this.getRow() - row) == Math.abs(this.getCol() - col)) // if self is on same diagonal as chesspiece, this is attack. we use absolute values to determine diagonal
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
     
           //increasing row vertical
      if (r > this.getRow() && c==this.getCol() ){
        for (int i=this.getRow()+1;i<r;i++){          
          moves[0][inc]=this.getCol();
          moves[1][inc]=i;
          inc++;
        }
      }
      // increasing col horizontal,
       if (r ==this.getRow() && c > this.getCol() ){
        for (int i=this.getCol()+1;i<c;i++){          
          moves[0][inc]=i;
          moves[1][inc]=this.getRow();
          inc++;
        }
      }
      
     //decreasing row vertical
      if (r < this.getRow() && c==this.getCol() ){
        for (int i=this.getRow()-1;i>r;i--){          
          moves[0][inc]=this.getCol();
          moves[1][inc]=i;
          inc++;
        }
      }
      
      //decreasing col horizontal
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
