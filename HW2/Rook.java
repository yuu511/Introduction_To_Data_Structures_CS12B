public class Rook extends ChessPiece{
 //constructor to make rook
  public Rook (int c, int r,boolean color){
  row=r;
  col=c;
  isWhite=color;
 }
  
 public boolean isAttacking (ChessPiece c){
    
    
  /*Reusing code from queen to verify
   *if a piece is in the same row or column.
   */    
       if (c.row==row||c.col==col){
      return true;
    }
  return false; 
}
}