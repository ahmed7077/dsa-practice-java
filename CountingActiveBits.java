/*Counting Active Bits in a Device Monitoring System
Imagine a device monitoring system that tracks the state of sensors in a factory. Each sensor is either active or inactive, and the state of all sensors is represented by a binary number. If a sensor is active, its corresponding bit is set to 1; otherwise, it is set to 0. To monitor the overall activity in the factory, you are required to count the number of active sensors (set bits) using a recursive approach.

Write a recursive function int countSetBits(int number) that takes an integer number (representing the state of the sensors in binary form) and returns the count of set bits in the binary representation of number.



Input Format

A single integer number.


Constraints

0≤number≤106


Output Format

An integer representing the count of set bits.


Example 1

Sample Input 1

13



Sample Output 1

3



Explanation  

The binary representation of 13 is 1101, which has three set bits (1s). Therefore, the output is 3.



Example 2

Sample Input 2

8



Sample Output 2

1



Explanation  

The binary representation of 8 is 1000, which has one set bit (1). Therefore, the output is 1. */
import java.util.Scanner;

public class CountingActiveBits{
    public static int countSetBits(int number) {
        if (number == 0) {
            return 0;
        }
        return (number & 1) + countSetBits(number >> 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(countSetBits(number));
    }
}