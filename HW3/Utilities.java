// Filename: Utilities.java
//
// Contains class Utilities that provides some utility functions
//
// Santrupti Nerli, Jan 2017

class Utilities {

  // Convenient method to print error message and exit
  // Input: String message to be printed
  // Output: void, simply exits program
  public static void errExit(String message)
  {
      System.err.println(message);
      System.exit(1);
  }

  // Convenient method to print the list at any point of time
  // It can be used to check if list is created properly or not
  // Input: None
  // Output: void, simply prints the list
  public static void printList(Node head) {
    // since first node is head, I want to move to the next pointer of head and not head itself
    Node myPiece = head.getNext();
    // loop through each node and print its contents
    while(myPiece != null) {
      System.out.println("Row: " + myPiece.getRow() + " Col: " + myPiece.getCol() + " Color: " + myPiece.getColor());
      myPiece = myPiece.getNext();
    }
  }

  // Method to return a charceter based on the chesspiece type
  // Input: Node to determine its type
  // Output: returns char based on chesspiece type and its color
  // It is useful for printing into files and checking validity
  public static char returnChessPieceType(Node node) {
      ChessPiece piece = node.getChessPiece();
      if(piece instanceof King) {
        if(piece.getColor() == true) {
            return 'k';
        }
        return 'K';
      }
      else if(piece instanceof Queen) {
        if(piece.getColor() == true) {
            return 'q';
        }
        return 'Q';
      }
      else if(piece instanceof Rook) {
        if(piece.getColor() == true) {
            return 'r';
        }
        return 'R';
      }
      else if(piece instanceof Bishop) {
        if(piece.getColor() == true) {
            return 'b';
        }
        return 'B';
      }
      if(piece instanceof Knight) {
        if(piece.getColor() == true) {
            return 'n';
        }
        return 'N';
      }
      if(piece instanceof Pawn) {
        if(piece.getColor() == true) {
            return 'p';
        }
        return 'P';
      }
      return '-';
  }

}
