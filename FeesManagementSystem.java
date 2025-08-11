import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private double totalFeesPaid;
    private double totalFeesDue;

    public Student(String name, int rollNumber, double totalFeesPaid, double totalFeesDue) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.totalFeesPaid = totalFeesPaid;
        this.totalFeesDue = totalFeesDue;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getTotalFeesPaid() {
        return totalFeesPaid;
    }

    public double getTotalFeesDue() {
        return totalFeesDue;
    }

    public void payFees(double amount) {
        totalFeesPaid += amount;
        totalFeesDue -= amount;
    }
}

class FeesManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeStudents();

        while (true) {
            System.out.println("\nExamination branch[FEES MANAGEMENT] Menu:");
            System.out.println("1. View Student Details");
            System.out.println("2. Pay collage Fees");
            System.out.println("3. Exit");
            System.out.print("Enter the choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewStudentDetails();
                    break;
                case 2:
                    payFees();
                    break;
                case 3:
                    System.out.println("the server closed successfully");
                    System.exit(0);
                default:
                    System.out.println("Invalid option ,please provide valid option.");
            }
        }
    }

    private static void initializeStudents() {
        students.add(new Student("Vemula Kusumakar", 101, 5000, 95000));
        students.add(new Student("Dokula Charan", 102, 50000, 50000));
        students.add(new Student("Vemula Chaitanya", 103, 65000, 35000));
    }

    private static void viewStudentDetails() {
        System.out.println("\nStudent Details:");
        for (Student student : students) {
            System.out.println("Name Of Student: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Total Fees Paid: Rs" + student.getTotalFeesPaid());
            System.out.println("Total Fees Due: Rs" + student.getTotalFeesDue());
            System.out.println("------------------------------");
        }
    }

    private static void payFees() {
        System.out.print("Enter your roll number: ");
        int rollNumber = scanner.nextInt();

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Hello, " + student.getName() + "!");
                System.out.println("Your total fees due: Rs" + student.getTotalFeesDue());
                System.out.print("Enter the amount you want to pay Rs:");
                double paymentAmount = scanner.nextDouble();

                if (paymentAmount <= student.getTotalFeesDue()) {
                    student.payFees(paymentAmount);
                    System.out.println("Payment successful!");
                    System.out.println("Total fees paid: Rs" + student.getTotalFeesPaid());
                    System.out.println("Remaining fees: Rs" + student.getTotalFeesDue());
                } else {
                    System.out.println(
                            "Invalid amount. Please enter an amount less than or equal to the total fees due.");
                }
                return;
            }
        }

        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
}
