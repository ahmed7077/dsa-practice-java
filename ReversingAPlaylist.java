/*Reversing a Playlist

Imagine you have a playlist of songs that you want to listen to. The songs are arranged in the order they were added to the playlist. Sometimes, you want to reverse the order of the playlist to listen to your favourite songs in the opposite order. This task can be represented using a singly linked list, where each node contains a song.

Your task is to reverse the playlist so that you can listen to the songs in the opposite order.



Input Format

The first line contains an integer n, representing the number of songs in the playlist.
The next n lines each contain a string, representing the name of a song.


Output Format

The output will be a single line containing the names of the songs in reverse order, separated by spaces.



Sample Input

5

Song1 Song2 Song3 Song4 Song5



Sample Output

Song5 Song4 Song3 Song2 Song1



Explanation

Input Playlist

You have a playlist with songs ordered from Song1 to Song5.

Reversing Process

You start at the head of the playlist (Song1) and begin to change the direction of the links between the songs.

After reversing, Song1 will point to null (as it becomes the last song), and the order will change so that Song5 becomes the first song in the playlist.

Final Output

You get the new playlist in the order you desire, from Song5 down to Song1. */
import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class ReversingAPlaylist {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}