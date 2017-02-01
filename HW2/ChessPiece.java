public abstract class ChessPiece{
  
 /* Each piece has a row and column position,
  * if isWhite is true, the piece is white
  * if isWhite is false, the piece is black
  */
  
  int row;
  int col;
  boolean isWhite;
  
  //abstract class takes method from subclasses
  abstract public boolean isAttacking(ChessPiece c);
 
}