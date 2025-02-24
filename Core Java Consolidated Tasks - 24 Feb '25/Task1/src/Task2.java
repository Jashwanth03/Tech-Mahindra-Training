import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Task 2 : Write a java program to accept the students name and marks in subjects and find the total and average of the marks and sort the list accordingly.

public class Task2 {

    public static void studInputs() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int n = in.nextInt();

        // Store student name and their marks details in a HashMap.
        // The float[] array holds: [English, Java Programming, C#, Python, Spanish, Total, Average]
        HashMap<String, float[]> students = new HashMap<>();

        for (int i = 0; i < n; i++){
            System.out.printf("Enter student %d name: \n", (i + 1));
            String student = in.next();

            System.out.println("Enter marks in English: ");
            float english = in.nextFloat();

            System.out.println("Enter marks in Java Programming: ");
            float javaProgramming = in.nextFloat();

            System.out.println("Enter marks in C#: ");
            float cc = in.nextFloat();

            System.out.println("Enter marks in Python: ");
            float python = in.nextFloat();

            System.out.println("Enter marks in Spanish: ");
            float spanish = in.nextFloat();

            float total = english + javaProgramming + cc + python + spanish;
            float average = total / 5;

            // Store the student's marks details
            students.put(student, new float[]{english, javaProgramming, cc, python, spanish, total, average});
            System.out.println("Student " + student + " has been assigned an average of " + average);
        }

        // Sorting according to average marks (descending order)
        // We build an ArrayList from the student entries and insert each entry in order.
        ArrayList<Map.Entry<String, float[]>> studentsList = new ArrayList<>();

        for (Map.Entry<String, float[]> entry : students.entrySet()){
            if (studentsList.isEmpty()){
                studentsList.add(entry);
            } else {
                int index = 0;
                boolean inserted = false;
                // Insert the entry in the correct position so that the list remains sorted
                for (Map.Entry<String, float[]> sortedEntry : studentsList){
                    if (entry.getValue()[6] > sortedEntry.getValue()[6]) { // compare average marks
                        studentsList.add(index, entry);
                        inserted = true;
                        break;
                    }
                    index++;
                }
                if (!inserted){
                    studentsList.add(entry);
                }
            }
        }

        // Print the sorted list of students
        System.out.println("\nSorted list of students based on average marks (highest first):");
        for (Map.Entry<String, float[]> entry : studentsList) {
            String studentName = entry.getKey();
            float[] details = entry.getValue();
            System.out.println("Student Name: " + studentName);
            System.out.println("Marks: English=" + details[0]
                    + ", Java Programming=" + details[1]
                    + ", C#=" + details[2]
                    + ", Python=" + details[3]
                    + ", Spanish=" + details[4]);
            System.out.println("Total: " + details[5] + ", Average: " + details[6]);
            System.out.println("---------------------------");
        }

        in.close();
    }

    public static void main(String[] args) {
        studInputs();
    }
}
