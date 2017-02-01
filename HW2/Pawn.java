public class Pawn extends ChessPiece{
//constructor to make pawn
 public Pawn (int c, int r,boolean color){
  row=r;
  col=c;
  isWhite=color;
 }
  
 public boolean isAttacking (ChessPiece c){ 

    
   /* If the piece is White,
    * the function checks the left and right diagonal
    * which only extends one space in the case
    * of a pawn.
    */
    if (isWhite){
     //right diagonal (/)
      if (c.row==row+1&&c.col==col+1){
        return true;
      }
     //left diagonal (\)
      if (c.row==row+1&&c.col==col-1){
        return true;
      }
    }
    
    //same function,but changed for black.
     if (!isWhite){
      //left diagonal (\)
      if (c.row==row-1&&c.col==col+1){
        return true;
      }
      //right diagonal (/)
      if (c.row==row-1&&c.col==col-1){
        return true;
      }
    }
    
    
    return false;
  }
}