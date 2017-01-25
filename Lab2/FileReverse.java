//-----------------------------------------------------------------------------
// FileReverse.java
// Reverses files
// Borrows a majority of the code from FileTokens.java
//-----------------------------------------------------------------------------
import java.io.*;
import java.util.Scanner;

class FileReverse{
   public static void main(String[] args) throws IOException{

      int lineNumber = 0;

      // check number of command line arguments is at least 2
      if(args.length < 2){
         System.out.println("Usage: FileCopy <input file> <output file>");
         System.exit(1);
      }

      // open files
      Scanner in = new Scanner(new File(args[0]));
      PrintWriter out = new PrintWriter(new FileWriter(args[1]));

      // read lines from in, extract and print tokens from each line
      while( in.hasNextLine() ){
         lineNumber++;

         // trim leading and trailing spaces, then add one trailing space so 
         // split works on blank lines
         String line = in.nextLine().trim() + " "; 

         // split line around white space 
         String[] token = line.split("\\s+");            
       
         //reverse and print out tokens: This is the part I added to reverse the tokens
         int n=token.length;
         
         for (int i=0; i<n;i++){    
         String temp="";
         temp=token[i];
         for (int j=temp.length()-1;j>=0;j--){
         out.print(temp.charAt(j));
         }  
          out.println("");    
         }  
        
         
  
      }

      // close files
      in.close();
      out.close();
   }
}

