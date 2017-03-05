//class function has two values : a function number, and priority
class Node {
public Function function;
public Node next;

public Node(Function newFunction){
  this.function=newFunction;
  this.next=null;
}

//head node
public Node(){
  this.function=null;
  this.next=null;
}

public int getFunction(){
 return this.function.funcNumber;
}

public int getPriority(){
 return this.function.priority;
}
}