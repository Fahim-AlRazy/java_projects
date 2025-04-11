/*Ultimate Java Basics Practice Problem: Student Management System
This problem covers variables, loops, conditionals, arrays, strings,
 methods, classes, objects, and file handling—all in one go.

Create a Student Management System that allows a user to:
Add a new student (name, roll number, marks).
View all students.
Search for a student by roll number.
Calculate the average marks of all students.
Save student records to a file and load them on program restart.

Requirements & Concepts Covered
Variables & Data Types (Store student details: name, rollNo, marks).
Loops (Iterate over student records).
Conditionals (if-else for menu selection and searching).
Arrays/ArrayLists (Store multiple students).
Methods (Encapsulate operations: addStudent(), searchStudent(), etc.).
File Handling (Save and load student records).
*/
public class student_management_system{
    public static void main(String[] args) {
       
    }
}

/*//Chat GPT Solution

 *
 *  import java.io.*;
import java.util.*;

class Student {
    String name;
    int rollNo;
    double marks;

    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String toString() {
        return rollNo + ", " + name + ", " + marks;
    }
}

 * 
 * 
 * 
 * class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static final String FILE_NAME = "students.txt";

    // Add a student
    static void addStudent(String name, int rollNo, double marks) {
        students.add(new Student(name, rollNo, marks));
        System.out.println("Student added successfully!");
    }

    // Display all students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search student by roll number
    static void searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Calculate average marks
    static void calculateAverageMarks() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate average.");
            return;
        }
        double total = 0;
        for (Student s : students) {
            total += s.marks;
        }
        System.out.println("Average Marks: " + (total / students.size()));
    }

    // Save students to file
    static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    // Load students from file
    static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                students.add(new Student(parts[1], Integer.parseInt(parts[0]), Double.parseDouble(parts[2])));
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadFromFile();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNo = sc.nextInt();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    addStudent(name, rollNo, marks);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.print("Enter Roll Number: ");
                    int searchRoll = sc.nextInt();
                    searchStudent(searchRoll);
                    break;
                case 4:
                    calculateAverageMarks();
                    break;
                case 5:
                    saveToFile();
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

 * 
 * 
 */