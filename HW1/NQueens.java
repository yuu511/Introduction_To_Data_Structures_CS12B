//Program designed to solve the n-queens problem.
import java.io.*;
import java.util.Scanner;

public class NQueens{

public boolean solveNQueens(int nQueens){
  /*board represented by boolean,
   * false= no queen
   * true= queen
   */
  boolean board[][]=new boolean[nQueens][nQueens];
  
 

  //sets the board to all false (no queens)
  for (int i=0;i<nQueens;i++){
    for (int j=0;j<nQueens;j++){
      board[i][j]=false;
    }
  }
  
  //Starts at the 1st column (represented by 0)
  //If the recursive function returns false, the it will hit this if statement
  if (solveFunc(board,0)==false){
    printMe(board);
    return false;
  }
  
  //otherwise it will return true and print the coordinates of the queens
  //by using method Printme.
  printMe(board);
  return true;
}

//Recursive Function
boolean solveFunc(boolean board[][],int column){
  //Base Case, if you get to the last column you solved it and returns true to print
  if (column==board.length){
    return true;
  }

  for (int i=0;i<board.length;i++){
   //if the next column has an available safe space, place piece
    if (muhSafeSpace(board,i,column)){
      board[i][column]=true;
   //recursively call next queen
     if (solveFunc(board,column+1)==true)
       return true;
   //if you can't, set last piece back to false and start over again
      board[i][column]=false;
    }
  }

  return false;
}

/*This functions determines whether or not a
 *space is eligible to have a piece placed.
 */
boolean muhSafeSpace(boolean[][]board,int row, int column){
 
  int i;
  int j;
  
  //checks for row
  for (i=0;i<column;i++){
    if (board[row][i]==true){
    return false;
  }
  }
 
 //checks lower diagonal to the left
  for (i=row, j=column; j>=0 && i<board.length; i++, j--){
    if (board[i][j] == true)
                return false;
  }
  
    
 //checks upper diagonal to the left
 for (i=row, j=column; i>=0 && j>=0; i--, j--){
    if (board[i][j] == true)
                return false;
 }
 
  return true;
}
//print function, for boards with length greater than 3, 
//printMe prints out column+ row of each queen.
  void printMe(boolean board[][]){
      try{
        PrintWriter out = new PrintWriter("solution.txt");
        if (board.length<=3){
          out.print("No Solution\n");
        }
        else{
       for (int i=0;i<board.length;i++){
      for (int j=0;j<board[0].length;j++){
        if ((board[i][j])==true){
          out.print((i+1)+" ");
          out.println(j+1);
      }
    }
    }   
   }  
        out.flush();
        out.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }
   }

     
   public static void main(String args[]){
     //Takes in one argument to solve for amount of nQueens
     if(args.length <1 ){
       System.out.println ("please input at least one integer to continue");
       System.exit(1);
     }
        int nQueens=Integer.parseInt(args[0]);
        NQueens Queen = new NQueens();
        Queen.solveNQueens(nQueens);

   }
}