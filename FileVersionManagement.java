/*File Version Management
You are developing a file version control system where each version of a file is stored on top of the previous versions using a stack-like structure. The system should allow users to manage file versions efficiently. Every time a new version is created, it should be pushed onto the stack. When users want to retrieve the latest version or remove it, the top version should be accessed or deleted. The goal is to implement this version control system using a stack built solely using queues.

You are tasked with implementing a version control system where the following operations are performed:

Push new version: Each time a new version of the file is created, it is pushed onto the top of the stack.
Pop the latest version: When the user wants to remove the latest version, it should be popped off from the top of the stack.
View the latest version: The user should be able to view the current version of the file without removing it.
Check if there are any versions: The user should be able to check if there are any versions saved in the system.
Your task is to implement a Main class using two queues that handle the following operations:

push(int version) – Pushes the new file version onto the stack.
pop() – Removes the latest file version from the stack and returns it.
top() – Returns the latest file version without removing it.
empty() – Checks if there are no versions saved and returns true if the stack is empty, false otherwise.


Input Format

The first line of input specifies the number of operations to be performed, followed by the specific operations like push, pop, top, or empty.


Output Format

For push: Print the pushed version number.
For pop: Print the version removed.
For top: Print the current top version.
For empty: Print true if the stack is empty, false otherwise.


Sample Input

6

push 1

push 2

top

pop

top

empty



Sample Output

Pushed: 1

Pushed: 2

Top version: 2

Popped: 2

Top version: 1

Is stack empty: false



Explanation

push 1: The first version is pushed, which results in the stack having [1].
push 2: The second version is pushed, resulting in the stack becoming [1, 2].
top: The current top version is 2, so output 2.
pop: The top version (2) is removed, leaving the stack with [1].
top: Now the current top version is 1, so output 1.
empty: The stack still has one version, so the result is false. */
import java.util.*;
class Stack{
  Queue<Integer> q1;
  Queue<Integer> q2;
  Stack(){
    q1=new LinkedList<>();
    q2=new LinkedList<>();
  }
  void push(int x){
    q2.offer(x);
    System.out.println("Pushed: "+x);
    while(!q1.isEmpty())
      q2.offer(q1.poll());
    Queue<Integer> temp=q1;
    q1=q2;
    q2=temp;
  }
  void pop(){
    System.out.println("Popped: "+q1.peek());
    q1.poll();
  }
  int top(){
    return q1.peek();
  }
  boolean isEmpty(){
    return q1.isEmpty();
  }
}
class  FileVersionManagement{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());
    Stack s=new Stack();
    for(int i=0;i<n;i++){
      String cmd=sc.nextLine();
      String[] parts=cmd.split(" ");
        if(parts[0].equals("push")){
            int version=Integer.parseInt(parts[1]);
            s.push(version);
        }
        else if(parts[0].equals("pop")){
            s.pop();
        }
        else if(parts[0].equals("top")){
            System.out.println("Top version: "+s.top());
        }
        else if(parts[0].equals("empty")){
            System.out.println("Is stack empty: "+s.isEmpty());
        }
}
  }
}   