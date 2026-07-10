/*Airport Baggage Handling System

You are part of the IT development team at an international airport, tasked with developing a simulation for the Baggage Handling System. In this system, baggage containers are stacked and unloaded according to the flight's loading/unloading schedule. The loading process strictly follows the Last In, First Out (LIFO) principle, meaning the last baggage container added to the stack is the first to be removed when needed.

Your role is to implement a Stack data structure using an array to simulate the baggage stacking and unstacking process efficiently. This will help the airport team manage baggage container operations, such as loading (Push) or unloading (Pop) containers, checking the topmost container (Top), verifying if the stack is empty (IsEmpty), and tracking the number of containers in the stack (Size).

The system must handle up to 100 baggage containers and ensure that operations are performed smoothly without exceeding the capacity. If the team tries to remove a baggage container from an empty stack, an alert should indicate a "Stack Underflow" error to prevent mishandling.

Your implementation will assist airport operators by offering real-time monitoring of the baggage stack, allowing them to make efficient decisions based on the current stack status.



Input Format

The system will receive a series of commands to manage the baggage containers:

The first line contains an integer N, which specifies the number of operations to be performed on the stack.
Each of the following N lines contains a command in one of the following formats:
Push X: Adds the baggage container X to the top of the stack.
Pop: Removes the topmost baggage container from the stack.
Top: Displays the baggage container at the top of the stack without removing it.
IsEmpty: Checks if the stack is empty and returns either true or false.
Size: Returns the number of baggage containers currently in the stack.


Output Format

For each Top, IsEmpty, and Size command, you will output the respective result on a new line. If a Pop command is issued on an empty stack, the system should output "Stack Underflow".



Constraints

The number of operations N is between 1 and 100.
The baggage container number for the Push X operation will be between 1 and 1000.
The stack can hold a maximum of 100 containers at any time.


Sample Input

8

Push 10

Push 20

Top

Pop

Top

Size

Pop

IsEmpty



Sample Output

20

10

1

true



Explanation

Push 10: The baggage container with ID 10 is added to the stack. The stack now contains [10].
Push 20: The baggage container with ID 20 is added on top of the stack. The stack now contains [10, 20].
Top: The system checks the topmost baggage container and finds 20. This value is printed without removing it.
Pop: The topmost container (20) is removed from the stack. The stack now contains [10].
Top: The system checks the topmost baggage container and finds 10. This value is printed.
Size: The system checks the number of containers in the stack, which is 1. This value is printed.
Pop: The topmost container (10) is removed, leaving the stack empty: [].
IsEmpty: The system checks if the stack is empty and finds that it is. Therefore, true is printed. */
import java.util.*;
class AirportBaggageHandlingSystem{
  static int[] stack=new int[100];
  static int top=-1;
  static void push(int x){
    if (top>99)
      System.out.println("Stack Overflow");
    else
      stack[++top]=x;
  }
  static void pop(){
    if (top==-1)
      System.out.println("Stack Underflow");
    else
      top--;
  }
  static int size(){
    return top+1;
  }
  static boolean isEmpty(){
    return top==-1;
  }
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());
    for(int i=0;i<n;i++){
      String op=sc.next();
      if (op.equals("Push")){
        int val=sc.nextInt();
        push(val);
      }
      else if(op.equals("Pop"))
        pop();
      else if(op.equals("Top")){
        if(top==-1)
          System.out.println("Stack Underflow");
}
    }
}
}