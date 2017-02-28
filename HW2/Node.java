//Node = pieces of a linked list
class Node{
  public ChessPiece piece;
  public Node next;

//constructor for node, that stores a chesspiece, attatches null at the end
 public Node (int col, int row, char character){
    if (character=='b')
      this.piece=new Bishop(col,row,true);
    if (character=='B')
      this.piece=new Bishop(col,row,false);
    if (character=='k')
      this.piece=new King(col,row,true);
    if (character=='K')
      this.piece=new King(col,row,false);
    if (character=='n')
      this.piece=new Knight(col,row,true);
    if (character=='N')
      this.piece=new Knight(col,row,false);
    if (character=='p')
      this.piece=new Pawn(col,row,true);
    if (character=='P')
      this.piece=new Pawn(col,row,false);
    if (character=='q')
      this.piece=new Queen(col,row,true);
    if (character=='Q')
      this.piece=new Queen(col,row,false);
   if (character=='r')
      this.piece=new Rook(col,row,true);
    if (character=='R')
      this.piece=new Rook(col,row,false);
    
    this.next=null;
  }

 
  public Node (){
    this.piece=null;
    this.next=null;
  }
}