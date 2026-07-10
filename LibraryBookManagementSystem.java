/*Library Book Management System

In a busy library, returned books pile up at the counter before they are sorted and placed back on the shelves. The library staff faces the challenge of processing books in the correct order so that the first book returned is placed back on the shelves last, ensuring that the most recent returns are processed first. To simulate this process, you are tasked with designing a Library Book Management System that efficiently manages the returned books using a Stack data structure implemented with a Linked List.

In this system, the librarian interacts with a stack of books where each book is treated as a node in a linked list. The stack follows the Last In, First Out (LIFO) principle, meaning the last book added to the stack will be the first one removed for shelving. This ensures that the most recent returns are processed first, which is critical for avoiding delays in returning popular books to the shelves.

Your role is to implement a Stack using a Linked List to help the librarian perform essential operations:

Push Book: When a user returns a book, it is placed at the top of the stack. Each book has a unique name, which is stored as a string.
Pop Book: Once the librarian is ready to return a book to the shelves, the topmost book is removed from the stack.
Top Book: The librarian may want to see which book is at the top of the stack (i.e., the most recently returned book) without removing it.
IsEmpty: The librarian can check whether there are any books in the stack at the counter.
Size: The librarian can check how many books are currently at the counter.
This system ensures that the librarian manages the returned books efficiently and prevents issues such as stacking too many books or accidentally removing books when the stack is empty.



Input Format

The first line contains an integer N, representing the number of operations.
Each of the next N lines contains one of the following commands:
"Push BookName": Add a book named BookName to the top of the stack.
"Pop": Remove the topmost book from the stack.
"Top": Display the name of the book on the top of the stack.
"IsEmpty": Print true if the stack is empty; otherwise, print false.
"Size": Print the number of books in the stack.


Output Format

For each "Top", "IsEmpty", and "Size" operation, the system prints the result on a new line.
If the "Pop" or "Top" operation is called on an empty stack, the system prints "Stack Underflow".


Constraints

1 <= N <= 100
The name of each book in the Push BookName operation will be a string with up to 100 characters.


Sample Input

7

Push HarryPotter

Push TheHobbit

Top

Size

Pop

Top

IsEmpty



Sample Output

TheHobbit

2

HarryPotter

false



Explanation

Push HarryPotter: The book "HarryPotter" is added to the stack. The stack is now ["HarryPotter"].
Push TheHobbit: The book "TheHobbit" is added to the stack. The stack is now ["HarryPotter", "TheHobbit"].
Top: The system displays the topmost book, "TheHobbit", which is the most recently returned book.
Size: The system displays 2, indicating there are two books in the stack.
Pop: The book "TheHobbit" is removed from the stack. The stack is now ["HarryPotter"].
Top: The system displays the topmost book, "HarryPotter".
IsEmpty: The system displays false, indicating that the stack is not empty. */
import java.util.*;
class Node{
  String book;
  Node next;
  Node(String book){
    this.book=book;
    this.next=null;
  }
}
class Stack{
  Node top;
  int size;
  Stack(){
    this.top=null;
    this.size=0;
  }
  Node push(String book){
    Node nn=new Node(book);
    if(top==null){
      top=nn;
      size++;
      return nn;
    }
    nn.next=top;
    top=nn;
    size++;
    return top;
  }
  void pop(){
    if(top==null){
      System.out.println("Stack Underflow");
      return;
    }
    top=top.next;
    size--;
  }
  void peek(){
    if(top==null){
      System.out.println("Stack Underflow");
      return;
    }
    System.out.println(top.book);
  }
  int size(){
    return size;
  }
  boolean isEmpty(){
    return top==null;
  }
}
class AirportBaggageHandlingSystem{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());
    Stack s=new Stack();
    for (int i=0;i<n;i++){
      String op=sc.nextLine();
      if(op.startsWith("Push")){
        String val=op.substring(5);
        s.push(val);
      }
      else if(op.equals("Pop"))
        s.pop();
      else if(op.equals("Top"))
        s.peek();
      else if(op.equals("Size"))
        System.out.println(s.size());
      else if(op.equals("IsEmpty"))
        System.out.println(s.isEmpty());
    }
  }
}