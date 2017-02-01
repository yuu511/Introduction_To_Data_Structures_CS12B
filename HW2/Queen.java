public class Queen extends ChessPiece{
//constructor to make queen
  public Queen (int c,int r,boolean color){
    row=r;
    col=c;
    isWhite=color;
  }
public boolean isAttacking (ChessPiece c){

   /* If a queen is in the same row or column 
    * as another chess piece, isAttacking returns true
    */ 
    if (c.row==row||c.col==col){
      return true;
    }
   
   /* If a queen is in the same diagonal 
    * as another queen, isAttacking returns true.
    * For this function I used slope to represent diagonal.
    * Diagonal= having a slope of 1 or -1.
    * If the absolute value of the difference of rows is equal to the 
    * absolute value of difference in columns,
    * the slope is either 1 or -1, and therefore a diagonal.
    */
    
   double rowDifference=Math.abs(c.row-row);
   double columnDifference=Math.abs(c.col-col);
   if (rowDifference==columnDifference){
     return true;
   }
   return false;
 }  
}