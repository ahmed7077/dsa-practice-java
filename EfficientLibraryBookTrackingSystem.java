/*Efficient Library Book Tracking System
You are tasked with developing a Book Management System for a university library. The library needs a system to efficiently store and manage records of all the books available for borrowing. Each book is assigned a unique Book ID between 1 and 1000 for identification.

Since the library staff and students frequently search for books by their Book ID, the system must support quick lookups. To achieve this, you decide to use a hash table where books are stored based on their Book ID. The hash table will be implemented using a quadratic probing technique to handle collisions. The hash function will be hash(bookID) = bookID % 100.



Input Fromat

The first line contains an integer n, the number of books.
The next n lines contain two values: the bookID and the bookTitle.


Output Format

For each book ID query, print the book title using quadratic probing. If the book ID is not found, print "Book not found."


Sample Input

5

101

Introduction to Algorithms

201

Data Structures in Java

305

Operating Systems

207

Database Management Systems

107

Artificial Intelligence

3

101

305

999



Sample Output

Introduction to Algorithms

Operating Systems

Book not found



Explanation

The first input value 5 indicates that there are 5 books to be stored.
The subsequent lines represent each book’s Book ID and Title:
Book ID 101: "Introduction to Algorithms"
Book ID 201: "Data Structures in Java"
Book ID 305: "Operating Systems"
Book ID 207: "Database Management Systems"
Book ID 107: "Artificial Intelligence"
After storing the book records, the system receives 3 queries:
Query for Book ID 101 returns "Introduction to Algorithms".
Query for Book ID 305 returns "Operating Systems".
Query for Book ID 999 returns "Book not found".
Collision Handling:
When inserting Book ID 101 and Book ID 201, both produce the hash value 1, causing a collision.
Quadratic probing places Book ID 201 at the next available slot (index 5) to resolve the collision. */

import java.util.Scanner;

public class EfficientLibraryBookTrackingSystem {

    private static final int TABLE_SIZE = 100;
    private Book[] hashTable;

    public EfficientLibraryBookTrackingSystem() {
        hashTable = new Book[TABLE_SIZE];
    }

    public void insert(int bookID, String bookTitle) {
        int index = probe(bookID);

        if (hashTable[index] != null && hashTable[index].getBookID() != bookID) {
            // Handle collision by updating the title
            hashTable[index].setBookTitle(bookTitle);
        } else {
            hashTable[index] = new Book(bookID, bookTitle);
        }
    }

    public String search(int bookID) {
        int index = probe(bookID);

        if (hashTable[index] != null && hashTable[index].getBookID() == bookID) {
            return hashTable[index].getBookTitle();
        } else {
            return "Book not found";
        }
    }

    private int probe(int bookID) {
        int index = bookID % TABLE_SIZE;
        int probeStep = 1;

        while (hashTable[index] != null && hashTable[index].getBookID() != bookID) {
            index = (index + probeStep * probeStep) % TABLE_SIZE;
            probeStep++;
        }

        return index;
    }

    public static void main(String[] args) {
        EfficientLibraryBookTrackingSystem library = new EfficientLibraryBookTrackingSystem();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int bookID = scanner.nextInt();
            String bookTitle = scanner.next();
            library.insert(bookID, bookTitle);
        }

        while (scanner.hasNextInt()) {
            int queryBookID = scanner.nextInt();
            System.out.println(library.search(queryBookID));
        }
    }


class Book {
    private int bookID;
    private String bookTitle;

    public Book(int bookID, String bookTitle) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}
}

