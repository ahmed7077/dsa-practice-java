/*Movie Theatre Seat Reservation System

You are designing a ticket booking system for a movie theatre that operates in a circular manner. The theatre has a fixed number of seats for each show, and customers can book tickets in a First-Come-First-Served (FCFS) manner. However, the seating arrangement is circular, meaning if all seats are booked and new customers want to book, the next available seat is from the beginning of the arrangement (if seats at the beginning have been vacated). You are tasked with implementing this booking system using a Circular Queue.



Problem Statement

You are required to implement a circular queue for a ticket booking system where:

Add a booking: When a customer books a ticket, they are assigned the next available seat. If all seats are booked, the system should inform the customer that no seats are available.
Remove a booking: When a customer cancels their booking, the seat is vacated, and it can be reassigned to new customers.
View the next booking: The system can view the next seat number to be processed for cancellation or retrieval.
Check if all seats are filled: The system can check whether the queue is full or empty.
You are tasked with implementing a CircularQueue class in Java to handle these operations:

enqueue(int seat) – Adds a seat booking to the circular queue.
dequeue() – Removes the front seat (cancellation).
front() – Returns the seat number at the front of the queue without removing it.
isFull() – Checks if the queue is full (i.e., all seats are booked).
isEmpty() – Checks if the queue is empty (i.e., no seats are booked).


Input Format

The first line indicates the capacity of the queue.
The second line of input specifies the number of operations to be performed.
Each subsequent line specifies one operation like enqueue, dequeue, front, isFull, or isEmpty.


Output Format

For enqueue: Print the seat number that was booked or "Booking failed" if the queue is full.
For dequeue: Print the seat number that was canceled or "No booking to cancel" if the queue is empty.
For front: Print the seat number at the front or "No bookings" if the queue is empty.
For isFull: Print true if the queue is full, false otherwise.
For isEmpty: Print true if the queue is empty, false otherwise.


Sample Input

3

5

enqueue 1

enqueue 2

dequeue

front

isFull



Sample Output

Booked seat: 1

Booked seat: 2

Canceled seat: 1

Next seat to be canceled: 2

false



Explanation

enqueue 1: Books seat 1, as the queue is not full.
enqueue 2: Books seat 2, as the queue is not full.
dequeue: Cancels seat 1, the first booked seat.
front: Displays seat 2 as the next seat to be canceled.
isFull: Returns false, indicating the queue is not full. */
import java.util.Scanner;

class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int seat) {
        if (isFull()) {
            System.out.println("Booking failed");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = seat;
        size++;
        System.out.println("Booked seat: " + seat);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("No booking to cancel");
            return;
        }
        int seat = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Canceled seat: " + seat);
    }

    public void front() {
        if (isEmpty()) {
            System.out.println("No bookings");
            return;
        }
        System.out.println("Next seat to be canceled: " + queue[front]);
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class MovieTheatreSeatReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int capacity = scanner.nextInt();
        int numOperations = scanner.nextInt();

        CircularQueue cq = new CircularQueue(capacity);

        for (int i = 0; i < numOperations; i++) {
            String operation = scanner.next();

            if (operation.equals("enqueue")) {
                int seat = scanner.nextInt();
                cq.enqueue(seat);
            } else if (operation.equals("dequeue")) {
                cq.dequeue();
            } else if (operation.equals("front")) {
                cq.front();
            } else if (operation.equals("isFull")) {
                System.out.println(cq.isFull());
            } else if (operation.equals("isEmpty")) {
                System.out.println(cq.isEmpty());
            }
        }

        scanner.close();
    }
}

