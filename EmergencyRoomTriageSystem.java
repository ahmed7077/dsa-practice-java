/*Emergency Room Triage System

You are part of a development team creating a triage system for an emergency room in a hospital. When patients arrive at the emergency room, they are assessed based on the severity of their condition. Patients with more severe conditions should be treated first, regardless of their arrival time.

To implement this, you decide to use a priority queue, where each patient has a priority based on their condition. The system should allow for the following operations:

Enqueue: Add a patient to the queue with a given name and severity level (higher severity levels indicate higher priority).
Dequeue: Remove and return the name of the patient with the highest priority.
Display: Show the current queue status with patient names and their severity levels.


Input Format

The first line of input specifies the number of operations to perform.
Each subsequent line contains an operation:
For enqueue: ENQUEUE <patient_name> <severity_level>
For dequeue: DEQUEUE
For display: DISPLAY


Output Format

For DEQUEUE: Print the name of the patient being treated.
For DISPLAY: Print the current queue status with patient names and their severity levels.If queue is empty,Print "Queue is empty."
While Dequeuing if queue is empty print "Queue is empty. No patient to treat."


Sample Input

6

ENQUEUE John 2

ENQUEUE Alice 3

ENQUEUE Bob 1

DISPLAY

DEQUEUE

DISPLAY



Sample Output

Current Queue: Alice(3) John(2) Bob(1)

Treated Patient: Alice

Current Queue: John(2) Bob(1)



Explanation

The first command ENQUEUE John 2 adds patient John with severity level 2.
The second command ENQUEUE Alice 3 adds patient Alice with severity level 3.
The third command ENQUEUE Bob 1 adds patient Bob with severity level 1.
The DISPLAY command shows the current queue status: Alice(3) John(2) Bob(1).
The DEQUEUE command treats Alice, who has the highest severity level of 3.
The final DISPLAY command shows that only John and Bob remain in the queue. */
import java.util.*;

class Patient {
    String name;
    int severity;
    int order;

    Patient(String name, int severity, int order) {
        this.name = name;
        this.severity = severity;
        this.order = order;
    }
}

public class EmergencyRoomTriageSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        PriorityQueue<Patient> pq = new PriorityQueue<>(
            (a, b) -> {
                if (b.severity != a.severity)
                    return b.severity - a.severity; // higher severity first
                return a.order - b.order; // FIFO for same severity
            }
        );

        int count = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("ENQUEUE")) {
                String name = parts[1];
                int severity = Integer.parseInt(parts[2]);

                pq.add(new Patient(name, severity, count++));
            }

            else if (parts[0].equals("DEQUEUE")) {
                if (pq.isEmpty()) {
                    System.out.println("Queue is empty. No patient to treat.");
                } else {
                    System.out.println("Treated Patient: " + pq.poll().name);
                }
            }

            else if (parts[0].equals("DISPLAY")) {
                if (pq.isEmpty()) {
                    System.out.println("Queue is empty.");
                } else {
                    List<Patient> temp = new ArrayList<>(pq);

                    temp.sort((a, b) -> {
                        if (b.severity != a.severity)
                            return b.severity - a.severity;
                        return a.order - b.order;
                    });

                    StringBuilder sb = new StringBuilder();
                    sb.append("Current Queue: ");

                    for (Patient p : temp) {
                        sb.append(p.name)
                          .append("(")
                          .append(p.severity)
                          .append(") ");
                    }

                    System.out.println(sb.toString().trim());
                }
            }
        }
    }
}