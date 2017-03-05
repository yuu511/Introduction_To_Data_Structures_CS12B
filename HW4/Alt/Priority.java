//Priority.java
// Takes in a queue of functions with priorities
//Executes the highest priority function (which delete symbolizes) 
//If there are two functions with the same priority, delete the latest inserted one.

import java.io.*;
import java.lang.StringBuilder;

class Priority{
//writer to analysis.txt
 public static BufferedWriter writer;
 //Linked List
 public static Node head;

 //creates a new linked list
 public Priority(){
  head=new Node();
 }
 
 //inserts a node into a linked list
 public Node insert(Node func){
  Node temp=head.next;
  head.next=func;
  func.next=temp;
  return head;
 }
 
 //finds the node with the max priority
 //If there is a function with similar priority than the test node:
 //Since the linked list is stored with newer entries in the front,
 //and we are traversing in order,
 //maxNode will store the earliest inserted node. (first in,first out) 
 public Node findMaxPriority(){
    int max=0;
    Node test=head.next;
    Node maxNode=null;
    while(test!=null){
      if (test.function.priority > max){
        max=test.function.priority;
        maxNode=test;
      }
     test=test.next;
    }
    return maxNode;
 }
 
 //delete function and print to file function number
 public Node delete(Node toDel){
   Node prev=null;
   Node curr=head.next;
   while (curr!=null&&curr!=toDel){
     prev=curr;
     curr=curr.next;
   }
   if (curr==null)
     return curr;
   if (prev==null)
     head.next=head.next.next;
    else
     prev.next=curr.next;
    return curr;
 }
     
  //simple method for printing out information of the linked list members 
  public static void traverse(){
    Node current=head.next;
    while (current!=null){   
      System.out.print (current.function+"  ");
      System.out.print (current.function.funcNumber+" ");
      System.out.println (current.function.priority+" ");
      current=current.next;
    }
  }
 
  //deletes the function with the maximum priority and prints out the function number to file.
  //in the case of equal priority, delete the function that was inserted first.
  //function maxpriority() finds the appropriate node to delete.
  public void queueOperations(){   
    writeToAnalysisFile(findMaxPriority().function.funcNumber+" ");
    delete(findMaxPriority());
  }


 public static void readFromInputFile(){
    Priority p=null;
    
   try {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line;
  
   while ((line = reader.readLine()) != null) {  
   p=new Priority(); 
   //Splits the string by space
   //Assuming the input is in the format posted in the doc file, 
   //It should seperate the numbers and lone "d" characters, 
   //leaving "," and ")" in the strings for the number arguments.
   String[] args = line.split(" ");
   //for loop to check all of the arguments
   for (int i=0;i<args.length;i++){   
    StringBuilder newInt=new StringBuilder(); 
    //this for loop extracts all the numbers out of a string argument
    //(cleans up "," and ")")
    //and stores them in stringbuilder newint.
    for (int j=0;j<args[i].length();j++){    
     if (Character.isDigit(args[i].charAt(j))){     
      newInt.append(args[i].charAt(j));                                 
     }     
    }
     // "," is the "function" number argument (1st).
    // if the string argument has a ","in it, it will be formatted to a string with only numbers.
    if (args[i].contains(","))
    args[i]=newInt.toString();
       // ")" is the "priority" number argument (2nd)
    // if the string has a ")" in it, it will be formatted as a string with only numbers.
    //It then takes the formatted priority argument and the 
    //formatted number argument to add it as a node in the queue.
    if (args[i].contains(")")){
    args[i]=newInt.toString();    
    Function temp= new Function (Integer.parseInt(args[i-1]),Integer.parseInt(args[i]));
    Node toBeInserted= new Node(temp);
    p.insert(toBeInserted);
    } 
    //if the argument is "d", then it will execute the highest priority target.
     if (args[i].contains("d")){
     p.queueOperations();
     }  
    }
   //newline for formatting
   writer.write("\n");
   }
   reader.close();
  }
   
   
     catch (NumberFormatException e) {
        System.out.print("All arguments must be integers");
  // throw error incase parsing integer fails
        }
  catch (Exception e) {
        System.out.print("Exception occurred trying to read file"); 
  // throw a generic exception if failure to read occurs
        }
   }
  
 //simple method to write a string ot analysis file
   public void writeToAnalysisFile(String stringToWrite) {
    try {
        writer.write(stringToWrite);
    }
    catch (Exception e) {
       System.out.print("Exception occurred while trying to write to file: writeToAnalysisFile");
    }
   }
 
  public static void main (String[] args){
 try {
  writer = new BufferedWriter(new FileWriter("output.txt"));
  readFromInputFile();
  writer.close();
 }
  catch(Exception e) {
      System.out.print("Error while creating BufferedWriter");
    } 
 }
}