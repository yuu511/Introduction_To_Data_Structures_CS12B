//Homework 3: ChessMoves
//Takes in commands to move pieces stored in a linked list
//Checks for validity of moves
//Checks if any of the kings are in check or "weak" checkamte
//LinkedList code taken from HW2 Solution

import java.io.*;
import java.lang.*;

class ChessBoard {
 
  private static Node head; // linkedlist to store chesspieces
  private static int board_size; // board_size
  public static BufferedWriter writer; // write to write to file
 
  // constructor
  public ChessBoard() {
    head = new Node();
  }
 
  // Method to perform insertion at the front of the list
  // Input: Node to be inserted
  // Output: void
  public Node insert(Node piece) {
    Node temp = head.getNext();
    head.setNext(piece);
    piece.setNext(temp);
    return head;
  }
  
 //Method to perform deletion
 //Input: ChessPiece to be deleted from linkedlist
 //Output: Node
  public Node delete(ChessPiece c){
    Node prev=null;
    Node curr=head.getNext();
    while (curr!=null&&curr.getChessPiece()!=c){
      prev=curr;
      curr=curr.getNext();
    }
    if (curr==null)
      return curr;
    if (prev==null)
      head.getNext().setNext(head.getNext().getNext());
      else
        prev.setNext(curr.getNext());
      return curr;
  }

 
  // Method to find Node in a given location
  // Input: integer row and column to look for
  // Output: Node found
  public Node findChessPieceNode(int col, int row) {
    Node piece = head.getNext();
    while(piece != null) {
      if(piece.getRow() == row && piece.getCol() == col) {
        return piece;
      }
      piece = piece.getNext();
    }
    return null;
  }
 
  // Method to check if any piece exists in the query location
  // Input: integer array query
  // Output: returns the piece (in character) if found otherwise just returns '-'
  public char findChessPiece(int col, int row) {
    Node foundPiece = findChessPieceNode(col,row);
    if ( foundPiece != null) {
      return Utilities.returnChessPieceType(foundPiece);
    }
    return '-';
  }
 
  // Method to check if two nodes given are different or the same ones
  // It serves as a helper when trying to find the attack
  // Input: two nodes
  // Output: returns if they are same or different pieces
  public boolean isDifferent(Node one, Node other) {
    if(one.getRow() == other.getRow() && one.getCol() == other.getCol() && one.getColor() == other.getColor()) {
      return false;
    }
    return true;
  }
 
 
  // Method to write to the analysis.txt file
  // Input: String to write
  // Output: void, just write
  public void writeToAnalysisFile(String stringToWrite) {
    try {
        writer.write(stringToWrite);
    }
    catch (Exception e) {
        Utilities.errExit("Exception occurred while trying to write to file: writeToAnalysisFile"); // throw a generic exception if failure to read occurs
    }
  }
 
  // Method to iterate through the list and update a 2D array for printing the board
  // onto the console
  // Input: integer board number read from input.txt
  // Output: void, jusr print the solution
  public static void convertFromListToMatrixAndPrint(int board_no) {
    // Initialize isFilled board
    char[][] isFilled = new char[board_size+1][board_size+1];
    for(int i = 0; i < board_size; i++) {
      for(int j = 0; j < board_size; j++) {
        isFilled[i][j] = '-';
      }
    }
    // iterate through the list and update isFilled matrix
    Node piece = head.getNext();
    while(piece != null) {
      isFilled[piece.getRow()][piece.getCol()] = Utilities.returnChessPieceType(piece);
      piece = piece.getNext();
    }
  }
 
  // Method to read from input.txt
  // for each chessboard and query, perform all the required operations
  // an then proceed further
  // Input: none
  // Output: void, jusr read and perform requested operations
  public static void readFromInputFile() {
 
    int lineCtr = 0;
    ChessBoard c = null;
 
    try {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] args = line.split(" "); // Reader assumes that the input format is as given in the instruction
            // If the line is 2i, then I know that it is a configuration of a ChessBoard
            // so create a new ChessBoard here, parse board size and insert
            // given chesspieces into the linked list
            if(lineCtr % 2 == 0) {
              c = new ChessBoard();
              board_size = Integer.parseInt(args[0]);
              for(int i = 1; i < args.length; i += 3) {
                head = c.insert(new Node(args[i].charAt(0), Integer.parseInt(args[i+2]), Integer.parseInt(args[i+1])));
              }
            }
            else {
                // as soon as you read the query perform the requested
                // operations
              int[] query = new int[args.length];
              for(int z=0;z<args.length;z++){
                query[z] = Integer.parseInt(args[z]);
              }
             
                performOperations(c, query, lineCtr-1);
 

            }
            lineCtr++; // move to the next line
        }
        reader.close();
    }
    catch (NumberFormatException e) {
        Utilities.errExit("All arguments must be integers"); // throw error incase parsing integer fails
    }
    catch (IndexOutOfBoundsException e) {
        Utilities.errExit("Array index is out of bounds"); // throw error when inserting elements into arrays fail
    }
    catch (Exception e) {
        Utilities.errExit("Exception occurred trying to read file"); // throw a generic exception if failure to read occurs
    }
  }
  
  //Method to find White King
  //Input: nothing
  //Output: chesspiece (that is a white king)
  public ChessPiece findWhiteKing(){
    //get linkedlist
    Node piece = head.getNext();
    //tester piece
    ChessPiece test;      
    while(piece != null) {
      test=piece.getChessPiece();
      if (test instanceof King&&test.getColor()==true){
        return test;
    }
    piece=piece.getNext();
   }
    return null;
  }
  
 
  //Method to find Black King
  //Input: nothing
  //Output: chesspiece (that is a black king)
  public ChessPiece findBlackKing(){
    //first element of linked list
    Node piece = head.getNext();
    //tester piece
    ChessPiece test;      
    while(piece != null) {
      test=piece.getChessPiece();
      if (test instanceof King&&test.getColor()==false){
        return test;
    }
    piece=piece.getNext();
   }
    return null;
  }
  
  //Method to check if white king is in check
  //Input: nothing
  //Output: Chesspiece that is threatening for check;it will return null otherwise.
  public ChessPiece whiteKingCheck(){
    //first element of linked list
    Node piece =head.getNext();
    //get White king from linked list
      ChessPiece whiteKing;
      whiteKing=findWhiteKing();
      while(piece!=null){
        ChessPiece test=piece.getChessPiece();
       //if the test piece isn't the white king,
       //&& is attacking white king,
      //&&is not the same color as white king,
      //&&is not being blocked by another piece, it is threatening king under check.
        if (test!=whiteKing 
              &&test.isAttacking(whiteKing.getRow(),whiteKing.getCol())
              &&test.getColor()!=whiteKing.getColor()
              &&checkBlocking(test.getCol(),test.getRow(),whiteKing.getCol(),whiteKing.getRow())){
          return test;
        }
        piece=piece.getNext();
      }
      ChessPiece nopieces=null;
      return nopieces;
  }
 
   //Method to find white checkmate
  //requires that a king already be in check
  //uses a method to pull all available squares around king(represented by a 2d boolean array)
  //if all of the squares are being attacked, the king is in checkmate
  //input:none
  //output: boolean: true: checkmate  
  public boolean whiteKingCheckMate(){
   //first element of linked list
    Node piece =head.getNext();
    Node checking=null;
    //Retrieves White King
    ChessPiece whiteKing=findWhiteKing();
    //bufferzone gives the positions of the space around the white king (which will be used to determine checkmate)
    int[][]temp=whiteKing.bufferZone(board_size);
    //stores the positions of the buffer zone with a 2d boolean array
    //part of the buffer zone= true (everything else is false)
    boolean[][] hitbox=new boolean[board_size+1][board_size+1];
    for (int z=0;z<temp[0].length;z++){
      if(temp[1][z]!=0||temp[0][z]!=0){
      hitbox[temp[1][z]][temp[0][z]]=true;
    }
    }

    //whiteKingCheck retrieves a piece that has the white king under check
    ChessPiece aggressor=whiteKingCheck();
    
    
    //if there is no piece that is checking the king, return false
    if (aggressor==null){
      return false;
    }
    
    //marks the squares that the piece that is checking the king is already attacking
     for(int i=0;i<temp[0].length;i++){
     if(aggressor.isAttacking(temp[1][i],temp[0][i])&&checkBlocking(aggressor.getCol(),aggressor.getRow(),temp[0][i],temp[1][i])){
       hitbox[temp[1][i]][temp[0][i]]=false;
     }
     }
    //This while loop checks if all the spaces the king surrounds are being attacked
    //it sets the members of the buffer zone to false if attacked
    while(piece!=null){
        ChessPiece test=piece.getChessPiece();
        if (test.getColor()!=whiteKing.getColor()&&test!=aggressor&&test!=whiteKing){
            for(int i=0;i<temp[0].length;i++){
              if(test.isAttacking(temp[1][i],temp[0][i])&&aggressor!=null){
                hitbox[temp[1][i]][temp[0][i]]=false;
              }
            }
        }
        piece=piece.getNext();
    }
    
    //if there is nowhere the king can go,everything should be false.
    //if there is at least one true, that means the king has a place to escape.
      for (int a=0;a<board_size+1;a++){
      for (int b=0;b<board_size+1;b++){     
        if(hitbox[a][b]==true)
          return false;
      }
     }

    return true;
  }
 
  //Method to find black checkmate
  //requires that a king already be in check
  //uses a method to pull all available squares around king(represented by a 2d boolean array)
  //if all of the squares are being attacked, the king is in checkmate
  //input:none
  //output: boolean: true: checkmate 
   public boolean blackKingCheckMate(){
   //first element of linked list
    Node piece =head.getNext();
    Node checking=null;
    //Retrieves Black King
    ChessPiece blackKing=findBlackKing();
    //bufferzone gives the positions of the space around the white king (which will be used to determine checkmate)
    int[][]temp=blackKing.bufferZone(board_size);
    //stores the positions of the buffer zone with a 2d boolean array
    //part of the buffer zone= true (everything else is false)
    boolean[][] hitbox=new boolean[board_size+1][board_size+1];
    for (int z=0;z<temp[0].length;z++){
      
      if(temp[1][z]!=0&&temp[0][z]!=0){
      hitbox[temp[1][z]][temp[0][z]]=true;
    }
    }


      

    //blackKing retrieves a piece that has the black king under check
    ChessPiece aggressor=blackKingCheck();
    
    //if there is no piece that is checking the king, return false
    if (aggressor==null){
      return false;
    }
    
    //marks the squares that the piece that is checking the king is already attacking
     for(int g=0;g<temp[0].length;g++){
     if(aggressor.isAttacking(temp[1][g],temp[0][g])&&checkBlocking(aggressor.getCol(),aggressor.getRow(),temp[0][g],temp[1][g])){
       hitbox[temp[1][g]][temp[0][g]]=false;
     }   
    }


    //This while loop checks if all the spaces the king surrounds are being attacked
    //it sets the members of the buffer zone to false if attacked
    while(piece!=null){
        ChessPiece test=piece.getChessPiece();
        if (test.getColor()!=blackKing.getColor()&&test!=aggressor&&test!=blackKing){
            for(int i=0;i<temp[0].length;i++){
              if(test.isAttacking(temp[1][i],temp[0][i])&&aggressor!=null){
                hitbox[temp[1][i]][temp[0][i]]=false;
              }
            }
        }
        piece=piece.getNext();
    }

    
    
    //if there is nowhere the king can go,everything should be false.
    //if there is at least one true, that means the king has a place to escape.
      for (int a=0;a<board_size+1;a++){
      for (int b=0;b<board_size+1;b++){     
        if(hitbox[a][b]==true)
          return false;
      }
     }

    return true;
  } 
  //Method to check if white king is in checkmate
  //input: nothing
  //output: boolean that returns true if white is in checkmate.
   
  //Method to check if black king is in check
  //Input: nothing
  //Output: boolean: true if the black king is in check, false if it is not
    public ChessPiece blackKingCheck(){
    //first element of linked list
    Node piece =head.getNext();
    //get White king from linked list
      ChessPiece blackKing;
      blackKing=findBlackKing();
      while(piece!=null){
        ChessPiece test=piece.getChessPiece();
       //if the test piece isn't the white king,
       //&& is attacking white king,
      //&&is not the same color as white king,
      //&&is not being blocked by another piece, it is threatening king under check.
        if (test!=blackKing 
              &&test.isAttacking(blackKing.getRow(),blackKing.getCol())
              &&test.getColor()!=blackKing.getColor()
              &&checkBlocking(test.getCol(),test.getRow(),blackKing.getCol(),blackKing.getRow())){
          return test;
        }
        piece=piece.getNext();
      }   
      ChessPiece nopieces=null;
      return nopieces;
  }
    



          
    
  
  //Method to check if two pieces have a different color 
  //Input: (x,y) of Piece 1, (x,y) of Piece 2
  //Output: true=different, false=same)
  
   public boolean checkTwoColors(int pieceOneC,int pieceOneR,int pieceTwoC, int pieceTwoR){
   //if checks if there are two pieces to compare (assumes first piece should always exist)
    if(findChessPieceNode(pieceTwoC,pieceTwoR)!=null){
     ChessPiece tester1=findChessPieceNode(pieceOneC,pieceOneR).getChessPiece();
     ChessPiece tester2=findChessPieceNode(pieceTwoC,pieceTwoR).getChessPiece();
     if (tester1.getColor()==tester2.getColor())
       return false;
    }
    return true;
   }
  
  //Method to check if the piece's moves are appropriate
  //e.g. a bishop cannot move horizontally or vertically
  //Input: col,row of piece 1, col,row of attempted move
  //Output: true= legal move, false, not legal
   
    public boolean checkLegality(int pieceC,int pieceR,int col,int row){
    if(findChessPieceNode(pieceC,pieceR)!=null){
    ChessPiece tester=findChessPieceNode(pieceC,pieceR).getChessPiece();
    if(tester instanceof Pawn){
      if (tester.getColor()==true){
        if (tester.getRow()+1==row&&tester.getCol()==col)
          return true;
      }
      if (tester.getColor()==false){
        if (tester.getRow()-1==row&&tester.getCol()==col)
          return true;
      }
    }
    if(tester.isAttacking(row,col)){
      return true;
    }
    }
    return false;
    }
  
   //Method to check if any pieces are blocking one another
   //Input: col, row of piece l, col, row of attempted move
   //Output: true= NO blocking false= blocking
    public boolean checkBlocking(int pieceC,int pieceR,int col,int row){
       if(findChessPieceNode(pieceC,pieceR)!=null){
       ChessPiece tester=findChessPieceNode(pieceC,pieceR).getChessPiece();
       int[][]temp=tester.spacesTraversed(col,row,board_size);
         for (int j=0;j<temp[0].length;j++){
           if (findChessPieceNode(temp[0][j],temp[1][j])!=null){
             return false;
           }
         }       
       }
       return true;
    }
   
   
   //Method to move piece 
   //Input: col,row of piece to move, col,row to move
   //Output: moves piece to specified col,row
    
    public void moveMyPiece(int pieceC,int pieceR,int col,int row){
    //if there is a piece that is currently occupying square
    //removes piece currently occupying square 
   //(function checkTwoColors checks beforehand that these are of different color)
    if(findChessPieceNode(col,row)!=null){
     ChessPiece temp=findChessPieceNode(col,row).getChessPiece();
     delete(temp);
    }   
    //if there is a piece that is ready to move
    //move that piece
    if(findChessPieceNode(pieceC,pieceR)!=null){
    //Move piece to specified square by setting column
      findChessPieceNode(pieceC,pieceR).setNcolNrow(col,row);
    }
    }
   
  
    
    
    
  // Method to perform all the requested operations
  // checks for checkmate/check
  // check if the piece's move is valid
  // Input: ChessBoard and the query
  // Output: String with results to analysis.txt
 
    public static void performOperations(ChessBoard c, int[] query, int board_no) {
     //Uses stringbuilder from java.lang to store valid /invalid results on a string
      StringBuilder validInvalid=new StringBuilder();
      StringBuilder checkCheckmate=new StringBuilder();
     //Check / Checkmate Check
      
      if(c.whiteKingCheckMate())
      checkCheckmate.append("White checkmated");
      if(c.blackKingCheckMate())
      checkCheckmate.append("Black checkmated");
      
      //The methods whiteKingCheck and blackKingCheck look for 
      //a piece that is directly threatening the king.
      //if it cannot find one, then it returns null.
      if(c.whiteKingCheck()!=null&&!c.whiteKingCheckMate()&&!c.blackKingCheckMate())
      checkCheckmate.append("White in check ");
      if(c.blackKingCheck()!=null&&!c.whiteKingCheckMate()&&!c.blackKingCheckMate())
      checkCheckmate.append("Black in check ");
      if (c.whiteKingCheck()==null&&c.blackKingCheck()==null&&!c.whiteKingCheckMate())
      checkCheckmate.append("All kings safe");
    

      
     //Valid / Invalid Check (for loop to process all of the inputs)
     //If the processed move is valid, move the piece
     for(int i=0;i<query.length;i += 4){   
      
    //calls method to check if the piece is moving correctly
    //e.g. a rook cannot move diagonally, so the function would return false and print invalid
    //stops the for loop immediately if legality is false and prints invalid   
    //This method can handle pawns.
       if(c.checkLegality(query[i],query[i+1],query[i+2],query[i+3])==false){
          validInvalid.append("Invalid");
          break;
        }
      
    //calls method to check if the potential move involves two pieces of the same color
    //Stops immediately if the move is invalid color wise
        if(c.checkTwoColors(query[i],query[i+1],query[i+2],query[i+3])==false){
          validInvalid.append("Invalid");
          break;
        }
     
     //calls method to check if there is any blocking when the piece traverses the board
     //stops immediately if the move is invalid blocking wise
        if(c.checkBlocking(query[i],query[i+1],query[i+2],query[i+3])==false){
          validInvalid.append("Invalid");
          break;
        }
        
      //If passes all the checks,calls method to move piece at col,row (i,i+1) -> col,row (i+2,i+3)
      //and remove the previous piece inhabiting that square (if there is one)
        c.moveMyPiece(query[i],query[i+1],query[i+2],query[i+3]);
        validInvalid.append("Valid ");
   }
     //writes results to analysis file
     c.writeToAnalysisFile(validInvalid.toString()+"\n"); 
     c.writeToAnalysisFile(checkCheckmate.toString()+"\n");

   }
 
  // main method
  public static void main(String[] args) {
    try{
      writer = new BufferedWriter(new FileWriter("analysis.txt")); // open the file to write
      readFromInputFile(); // read from input file and perform operations
      writer.close(); // close the writer
    }
    catch(Exception e) {
      Utilities.errExit("Error while creating BufferedWriter");
    }
 
  }
}
 
// End