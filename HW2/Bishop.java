public class Bishop extends ChessPiece{
 //constructor to make bishop
  public Bishop (int c, int r,boolean color){
    col=c;
    row=r;
    isWhite=color; 
  }
  public boolean isAttacking(ChessPiece c){
    

  /*This uses the same code for checking diagonals
   *as seen in the Queen function. It takes the 
   *slope between two chess pieces and sees if it
   *evaluates to 1 or -1 (diagonal)
   *If it there is a piece that is diagonal to this piece,
   *the bishop is eligible to attack it.
   */
     double rowDifference=Math.abs(c.row-row);
     double columnDifference=Math.abs(c.col-col);
     if (rowDifference-columnDifference==0){
     return true;
     }
   return false;
  }
}