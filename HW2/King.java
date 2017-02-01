public class King extends ChessPiece{
 //constructor to make king
  public King (int c, int r,boolean color){
  row=r;
  col=c;
  isWhite=color;
 }
  
public boolean isAttacking (ChessPiece c){   
    

    
  //finds rise and run and converts to absolute value (to make things easier)
   double rowDifference=Math.abs(c.row-row);
   double columnDifference=Math.abs(c.col-col);  
   
  //if both rise and run are -+1,isAttacking is true
   if (rowDifference==1&&columnDifference==1){
     return true;
   }
   
   //if the piece is exactly one above or below the king,and in the same row, isAttacking is true
   if (rowDifference==0&&columnDifference==1){
     return true;
   }
   
   //if the piece is exactly one right or left of the king,and in the same column, isAttacking is true
   if (rowDifference==1&&columnDifference==0){
     return true;
   }
   
 
    return false;
 }
}