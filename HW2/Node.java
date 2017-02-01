//Node = pieces of a linked list
class Node{
  ChessPiece piece;
  Node next;

//constructor for node, that stores a chesspiece, attatches null at the end
  Node (ChessPiece newPiece){
    piece=newPiece;
    next=null;
  }
}