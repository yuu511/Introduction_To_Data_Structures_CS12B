// Filename: Node.java
//
// Contains the class Node that represents a node in a linked list
// which is used as node in a linked list
//
// Santrupti Nerli, Jan 2017

class Node {

  // This node stores the chess piece as its data
  private ChessPiece myPiece;
  // this is the next pointer to contact next node
  private Node next;

  // simple constructor
  // I will use this to create head pointer
  // without any data
  public Node() {
    this.myPiece = null;
    this.next = null;
  }

  // Method to create a node so that you can do insertion into the linkedlist afterwards
  // based on the parameters, create a corresponding chesspiece
  // Input: parameters of a chesspiece
  // Output: ChessPiece currently inserted
  public Node(char piece, int row, int col) {
    this.myPiece = null;
    boolean color = identifyColor(piece);
    if(piece == 'k' || piece == 'K') {
        this.myPiece = new King(row, col, color);
    }
    else if(piece == 'q' || piece == 'Q') {
        this.myPiece = new Queen(row, col, color);
    }
    else if(piece == 'r' || piece == 'R') {
        this.myPiece = new Rook(row, col, color);
    }
    else if(piece == 'b' || piece == 'B') {
        this.myPiece = new Bishop(row, col, color);
    }
    else if(piece == 'n' || piece == 'N') {
        this.myPiece = new Knight(row, col, color);
    }
    else if(piece == 'p' || piece == 'P') {
        this.myPiece = new Pawn(row, col, color);
    }
    else {
      Utilities.errExit("Cannot recognize chesspiece");
    }
  }

  // return the chesspiece stored in this node
  public ChessPiece getChessPiece() {
    return this.myPiece;
  }

  // return the node that is pointed by the current
  public Node getNext() {
    return this.next;
  }

  // at times I need to update this pointer. For example, in insertion case
  public void setNext(Node next) {
    this.next = next;
  }

  // return the row of the current chesspiece
  public int getRow() {
    return this.myPiece.getRow();
  }

  // return the col of the current chesspiece
  public int getCol() {
    return this.myPiece.getCol();
  }
  

  public void setNcolNrow(int x,int y){
    myPiece.setCol(x);
    myPiece.setRow(y);
  }


  // return the color of the current chesspiece
  public boolean getColor() {
    return this.myPiece.getColor();
  }

  // I will use identify color based on the character input I receive from solution.txt
  public boolean identifyColor(char piece) {
    // black represents false and white represents true
    if(piece == 'k' || piece == 'q' || piece == 'r' || piece == 'b' || piece == 'n' || piece == 'p') {
      return true;
    }
    return false;
  }
  


}

// End
