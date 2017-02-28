import java.io.*;

 class Chessboard{
 //initalize boardSize,Linked list
 public static int boardSize;
 public static Node head;
 public static BufferedWriter writer;
 
   // constructor for new chessBoard
  public Chessboard() {
    head = new Node();
  }
  
  //inserts and connects nodes in a linked list
  public Node insert (Node newNode){
    Node temp=head.next;
    head.next=newNode;
    newNode.next=temp;
    return head;
  }
  
  //finds node at col, row
   public Node findNode(int col, int row) {
    Node tester = head.next;
    while(tester != null) {
      if(tester.piece.col== col && tester.piece.row == row) {
        return tester;
      }
      tester = tester.next;
    }
    return null;
  }
  
   
  
  //simple method for printing out information of chessPieces in a linked list
  public static void traverse(){
    Node current=head.next;
    while (current!=null){   
      System.out.print (current.piece+" ");
      System.out.print (current.piece.col+" ");
      System.out.println (current.piece.row+" ");
      current=current.next;
    }
  }
  
  //reads / input
  public static void readInput(){
    int linecount=0;
    int[] secondLine=new int [2];
    Chessboard chessboard=null;
     try {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
        String[] values = line.split(" ");
        //reads the first lines input
          if(linecount % 2 == 0) {
              chessboard = new Chessboard();
              boardSize=Integer.parseInt(values[0]);
        //creates the apprropriate piece in the linked list
                for(int i = 1; i < values.length; i += 3) {
                head = chessboard.insert(new Node(Integer.parseInt(values[i+1]),Integer.parseInt(values[i+2]),values[i].charAt(0)));
              }
          }
          else{
          //reads the second lines of inputs
            secondLine[0]= Integer.parseInt(values[0]);
            secondLine[1]= Integer.parseInt(values[1]);
            castAnalysis(chessboard,secondLine);
          }
          linecount++;        
        }
        reader.close();
     }  
     catch (Exception e) {
       System.out.print("Error reading input.txt");
     }

  }
  
  //main method to run all of the checks to the analysis file
  public static void castAnalysis(Chessboard chessboard,int[]secondline){
  
    //ensures that there are no two pieces on the same spot and if there is exactly one king of each color
    if(!chessboard.checkKings()||!chessboard.checkListPieces()){
      outputAnalysis("Invalid\n");
      return;
     }
    
    //finds a chesspiece at the the query requested
    outputAnalysis(chessboard.findPiece(secondline[0],secondline[1])+" ");
    //finds a piece that is attacking another and prints it out to analysis file
    chessboard.attackingCheck();

  }
  
  //counts how many pieces there are in any col, row
  //returns how many pieces there are in that col,row
  public int checkAmountofPieces(int col,int row){
    Node dummy=head.next;
    int amountOfPieces=0;
    while (dummy!=null){
      if (dummy.piece.col==col && dummy.piece.row==row){
        amountOfPieces++;
      }
      dummy=dummy.next;
    }
    return amountOfPieces;
  }
  
  //checks for every col,row there is a piece if there are more than one piece on that col,row
  //returns true if not.
  public boolean checkListPieces (){
    Node dummy=head.next;
    while(dummy!=null){
      if (checkAmountofPieces(dummy.piece.col,dummy.piece.row)>1){
        return false;
      }
     dummy=dummy.next;
    }
    return true;
  }
  
  //function to check if there is exactly one black and one white king
  public boolean checkKings(){
    Node dummy=head.next;
    ChessPiece piece=null;
    int whiteKingCtr=0;
    int blackKingCtr=0;
    while(dummy!=null){
      piece=dummy.piece;
      if (piece instanceof King){
        if (piece.isWhite==true)
          whiteKingCtr++;
        if (piece.isWhite==false)
          blackKingCtr++;
      }
     dummy=dummy.next;
    }
     if (whiteKingCtr==1&&blackKingCtr==1){
       return true;
     }
     return false;   
    }
  
  //finds piece at col,row
  public char findPiece(int col, int row){
   Node dummy= findNode(col,row);
   if (dummy!=null){
     return findCharRepresentation(dummy);
   }
   return '-';
  }
  
  //checks to see if a piece is attacking another
  public void attackingCheck() {
   //Get linked list
    Node dummy = head.next;

   //nested while loop, which compares the pieces to eachother
    while(dummy != null) {
      Node compare = head.next;
      while(compare != null) {
        if(compare!=dummy && dummy.piece.isAttacking(compare.piece)) {
          outputAnalysis(findCharRepresentation(dummy) + " " + dummy.piece.col + " " + dummy.piece.row + " " + findCharRepresentation(compare) + " " + compare.piece.col + " " + compare.piece.row + "\n");
          return;
        }
        compare=compare.next;
      }
      dummy=dummy.next;
    }
    outputAnalysis("-\n");
  }
  
  //finds char representation of pieces
    public static char findCharRepresentation(Node node){
      ChessPiece piece = node.piece;
      if(piece instanceof King) {
        if(piece.isWhite==true) {
            return 'k';
        }
        return 'K';
      }
      if(piece instanceof Queen) {
        if(piece.isWhite==true) {
            return 'q';
        }
        return 'Q';
      }
      if(piece instanceof Rook) {
        if(piece.isWhite==true) {
            return 'r';
        }
        return 'R';
      }
      if(piece instanceof Bishop) {
        if(piece.isWhite==true) {
            return 'b';
        }
        return 'B';
      }
      if(piece instanceof Knight) {
        if(piece.isWhite==true) {
            return 'n';
        }
        return 'N';
      }
      if(piece instanceof Pawn) {
        if(piece.isWhite==true) {
            return 'p';
        }
        return 'P';
      }
      return 'x';
    }
    
  //method to write a string to analysis file
  public static void outputAnalysis(String string) {
    try {
        writer.write(string);
    }
    catch (Exception e) {
      System.out.print("writer error");
    }
  }
    
  public static void main(String[] args) {
    try{
      //file to write to
      writer = new BufferedWriter(new FileWriter("analysis.txt"));
      //read input.txt
      readInput();
      writer.close();
    }
    catch (Exception e){
      System.out.print("BufferedWriter error.");
    }
  }

}