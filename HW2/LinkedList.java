//Linked List that connects the nodes
class LinkedList {
  Node head=null;
 //method that allows for insertion of nodes
  void insert(ChessPiece piece){
    Node latest=new Node (piece);
    latest.next=head;
    head=latest;
  }
 
  /* method that takes in two int parameters, row and column.
   * The method will traverse the linked list and find 
   * the piece with those values and return that piece.
   */
  
  ChessPiece find(int pieceCol,int pieceRow){
    Node current=head;
    while (current!=null){
      if (current.piece.col==pieceCol &&current.piece.row==pieceRow){
        return current.piece;
      }
      current=current.next;
    }
      return null;
  }
  
  //Simple function that calculates size of the linked list, which in this case, is number of pieces.
  public int size(){
    Node current=head;
    int x=0;
    while (current!=null){
      x++;
      current=current.next;
    }
    return x;
  }
 
  //Finds two attacking chess pieces
  //uses linked list method find, which finds a piece in a linked list given two integers
  //uses linked list method size, which find the size of a linked list
  //stores it in an array and returns 2 pieces: one attacking the other
   ChessPiece[] findAttackingPieces(LinkedList pieces,int boardSize){
    int a=0;
    ChessPiece[] possiblePieces=new ChessPiece[pieces.size()];
    
    
    //two pieces
    ChessPiece[] twoPieces=new ChessPiece[2];
    ChessPiece[] emptySet=new ChessPiece[2];
    
    //uses linked list method find to locate pieces
     for (int i=1;i<=boardSize;i++){
      for (int j=1;j<=boardSize;j++){
        if (pieces.find(j,i)!=null){
         ChessPiece dummy=pieces.find(j,i);
         possiblePieces[a]=dummy;
         a=a+1;
        }
      }
     }
        //checks for one piece that attacks antoher
       for(int c=0;c<possiblePieces.length;c++){
         for (int b=0;b<possiblePieces.length;b++){
           if(c!=b){ 
           if (possiblePieces[c].isAttacking(possiblePieces[b])){
             ChessPiece attackingPiece1=possiblePieces[c];
             ChessPiece attackingPiece2=possiblePieces[b];
             twoPieces[0]=attackingPiece1;
             twoPieces[1]=attackingPiece2;
             return twoPieces; 
           }
          }
         }
       }
       //otherwise return empty
      return emptySet;   
  } 
 //Checks if all the pieces are filled into unique squares,
 //and also checks if there is a white and black king.
 //returns true if valid board,false if invalid.
 //uses linked list method find, which finds a piece in a linked list given two integers (col,row)
 //uses linked lsit method size, which finds the size of a linked list
  
    boolean canPlace(LinkedList pieces,int boardSize){
  //this function stores piece row and column values into two arrays.
  //If there are two pieces with the same row and column, it will not store anything.
  int a=0;
  
  //initialize boolean white and black king (these will turn true if there is a white and black king)
  boolean whiteKing=false;
  boolean blackKing=false;
  
  int myCols[]=new int[pieces.size()];
  int myRows[]=new int[pieces.size()];
    for (int i=1;i<=boardSize;i++){
      for (int j=1;j<=boardSize;j++){
        if (pieces.find(j,i)!=null){
         ChessPiece dummy=pieces.find(j,i);
         myCols[a]=dummy.col;
         myRows[a]=dummy.row;
         
         //this if loop checks if there is a white and black king among the pieces. 
         if(dummy.toString().contains("King")){
           if(dummy.isWhite==true){
             whiteKing=true;
           }
           if(dummy.isWhite==false){
             blackKing=true;
           } 
         }
         a=a+1;
        }
      }
    }
    
    //if there is no white king or black king, return false (board invalid)
    if (!whiteKing||!blackKing){
      return false;
    }
    
  //Not stored= array is at default value (0)
  //So if something is not stored, a piece is invalid, and canPlace returns false.
    for (int b=0;b<pieces.size();b++){
      if (myCols[b]==0&&myRows[b]==0){
        return false;
      }
    }
  
  //return true if board is valid
    return true;
  }
  
} 
   