public class Knight extends ChessPiece{
 //constructor to make knight
  public Knight (int c, int r,boolean color){
  row=r;
  col=c;
  isWhite=color;
 }
  
 
 public boolean isAttacking (ChessPiece c){
    
  
  /* This function checks to see if
   * a knight is eligible to attack a certain
   * piece on the board. I used the slope between the two
   * pieces to determine this. Since the knight moves in an
   * "L" motion, it is either going to move with slope +-2
   * or slope +-1/2,and this function checks exactly that.
   */
   
   //finds rise and run and converts to absolute value (to make things easier)
   double rowDifference=Math.abs(c.row-row);
   double columnDifference=Math.abs(c.col-col);
   
   
   // Rise x run should be 2 (L-shape)
   double slopeBetweenPieces=columnDifference*rowDifference;

   if (slopeBetweenPieces==2){
     return true;
   }
   return false; 
 }
}