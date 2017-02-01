import java.io.*;
import java.util.Scanner;
 class Chessboard{
 //initalize boardSize,Linked list
 static public int boardSize=0;
 static public LinkedList pieces= new LinkedList();
 
//[[NOTE]]:the program can only handle 2 lines at a time per text file

 public static void main (String[] args)throws IOException{    
    Scanner in=new Scanner(new File("input.txt"));
    PrintWriter out=new PrintWriter(new FileWriter("analysis.txt"));
   System.out.print("[[[[[[[NOTE]]]]]]]]]this program can only handle two lines at a time");
    while(in.hasNextLine()){
    //parsing file line by line taken from FileTokens.java (Lab 2)
       String line = in.nextLine().trim()+" ";
       String line2= in.nextLine().trim()+" ";
       String[] token = line.split("\\s+");
       String[] token2 = line2.split("\\s+");

    //board size is always the first token
     boardSize=(Integer.parseInt(token[0]));
   
    /* for loop starts at 1 (second token)
     * stops two tokens before the end 
     * takes in letter and the two integers after that to create the appropriate piece.
     * non capital=white (true) and capital=black (false);
     */
      for (int i=1;i<token.length-2;i=i+3){
      if (token[i].contains("k")){
      King newPiece=new King (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),true);
      pieces.insert(newPiece);
      }
      if (token[i].contains("K")){
      King newPiece=new King (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),false);
      pieces.insert(newPiece);
      }
      
      if (token[i].contains("q")){
      Queen newPiece=new Queen (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),true);
      pieces.insert(newPiece);
      }
      if (token[i].contains("Q")){
      Queen newPiece=new Queen (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),false);
      pieces.insert(newPiece);
      }
      
      if (token[i].contains("r")){
      Rook newPiece=new Rook (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),true);
      pieces.insert(newPiece);
      }
      if (token[i].contains("R")){
      Rook newPiece=new Rook (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),false);
      pieces.insert(newPiece);;
      }
      
      if (token[i].contains("b")){
      Bishop newPiece=new Bishop (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),true);
      pieces.insert(newPiece);
      }
      if (token[i].contains("B")){
      Bishop newPiece=new Bishop (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),false);
      pieces.insert(newPiece);
      }
      
      if (token[i].contains("n")){
      Knight newPiece=new Knight (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),true);
      pieces.insert(newPiece);
      }
      if (token[i].contains("N")){
      Knight newPiece=new Knight (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),false);
      pieces.insert(newPiece);
      }
      
      if (token[i].contains("p")){
      Pawn newPiece=new Pawn (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),true);
      pieces.insert(newPiece);
      }
      if (token[i].contains("P")){
      Pawn newPiece=new Pawn (Integer.parseInt(token[i+1]),Integer.parseInt(token[i+2]),false);
      pieces.insert(newPiece);
      }    
     }
  
 
    

      //method canPlace checks if a chessboard is valid (no 2 pieces on one square, 1 black king, 1 white king)
       if(pieces.canPlace(pieces,boardSize)){
       
       //takes the two integers [col] [row] on the next line and uses LinkedList method .find to check if
       //a piece with that [col] [row] exists.
       ChessPiece dummy= (pieces.find(Integer.parseInt(token2[0]),Integer.parseInt(token2[1])));
       
       //if not, print -
         if(dummy==null){
          out.print("- ");
          
         }
      //otherwise print appropriate Char + space.
         else{
        
          //king
           if(dummy.toString().contains("King")){
             if(dummy.isWhite==true){
               out.print('k'+" ");
             }
             else
               out.print('K'+" ");
          }
         
           //bishop
           if(dummy.toString().contains("Bishop")){
             if(dummy.isWhite==true){
               out.print('b'+" ");
             }
             else
               out.print('B'+" ");
          }
           
           //knight
           if(dummy.toString().contains("Knight")){
             if(dummy.isWhite==true){
               out.print('n'+" ");
             }
             else
               out.print('N'+" ");
          }
           
           //pawn
           if(dummy.toString().contains("Pawn")){
             if(dummy.isWhite==true){
               out.print('p'+" ");
             }
             else
               out.print('P'+" ");
          }
           
           //Queen
           if(dummy.toString().contains("Queen")){
             if(dummy.isWhite==true){
               out.print('q'+" ");
             }
             else
               out.print('Q'+" ");
          }
           
          //Rook
           if(dummy.toString().contains("Rook")){
             if(dummy.isWhite==true){
               out.print('r'+" ");
             }
             else
               out.print('R'+" ");
          }  
         }
         
        //method twoAttackingPieces returns two pieces that are attacking eachother.
        ChessPiece[] twoAttackingPieces=new ChessPiece[2];
        twoAttackingPieces=pieces.findAttackingPieces(pieces,boardSize);
        
        //if there are none= print "-"
        if (twoAttackingPieces[0]==null&&twoAttackingPieces[1]==null){
          out.print("-");
        }
        else {
          
        //otherwise, print the appropriate values
            for(int i=0;i<twoAttackingPieces.length;i++){
            
            //King
            if(twoAttackingPieces[i].toString().contains("King")){
              if(twoAttackingPieces[i].isWhite==true){
                out.print('k'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }
              else
                out.print('K'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
           }
           
            //Knight
             if(twoAttackingPieces[i].toString().contains("Knight")){
              if(twoAttackingPieces[i].isWhite==true){
                out.print('n'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }
              else
               out.print('N'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
            }  
           
            //Bishop
             if(twoAttackingPieces[i].toString().contains("Bishop")){
              if(twoAttackingPieces[i].isWhite==true){
                out.print('b'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }
              else
                out.print('B'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }  
             
            //Queen
             if(twoAttackingPieces[i].toString().contains("Queen")){
              if(twoAttackingPieces[i].isWhite==true){
                out.print('q'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }
              else
                out.print('Q'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              } 
             
             //Rook
             if(twoAttackingPieces[i].toString().contains("Rook")){
              if(twoAttackingPieces[i].isWhite==true){
                out.print('r'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }
              else
                out.print('R'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }
            
            //Pawn
             if(twoAttackingPieces[i].toString().contains("Pawn")){
              if(twoAttackingPieces[i].isWhite==true){
                out.print('p'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }
              else
                out.print('P'+" "+twoAttackingPieces[i].col+" "+twoAttackingPieces[i].row+" ");
              }  

        
            }
        }
    }
       else{
         out.print("Invalid");
       }
  }
    in.close();
    out.close();
 }  
}