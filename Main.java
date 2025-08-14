import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;
    private int total;
    private double average;
    private char grade;

    public Student(String name, int subjects) {
        this.name = name;
        this.marks = new int[subjects];
    }

    public void inputMarks() {
        Scanner sc = new Scanner(System.in);
        total = 0;
        for (int i = 0; i < marks.length; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");
                    int mark = Integer.parseInt(sc.nextLine());
                    if (mark < 0 || mark > 100) {
                        throw new IllegalArgumentException("Marks must be between 0 and 100.");
                    }
                    marks[i] = mark;
                    total += mark;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        calculateAverage();
        assignGrade();
    }

    private void calculateAverage() {
        average = (double) total / marks.length;
    }

    private void assignGrade() {
        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else grade = 'F';
    }

    public void displayResult() {
        System.out.println("\n--- Student Grade Report ---");
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        int subjects;
        while (true) {
            try {
                System.out.print("Enter number of subjects: ");
                subjects = Integer.parseInt(sc.nextLine());
                if (subjects <= 0) throw new IllegalArgumentException("Number of subjects must be positive.");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Student student = new Student(name, subjects);
        student.inputMarks();
        student.displayResult();
    }
}
