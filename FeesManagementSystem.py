class Student:
    def __init__(self, name, roll_number, total_fees_paid, total_fees_due):
        self.name = name
        self.roll_number = roll_number
        self.total_fees_paid = total_fees_paid
        self.total_fees_due = total_fees_due

    def get_name(self):
        return self.name

    def get_roll_number(self):
        return self.roll_number

    def get_total_fees_paid(self):
        return self.total_fees_paid

    def get_total_fees_due(self):
        return self.total_fees_due

    def pay_fees(self, amount):
        self.total_fees_paid += amount
        self.total_fees_due -= amount


class FeesManagementSystem:
    def __init__(self):
        self.students = []
        self.initialize_students()

    def initialize_students(self):
        self.students.append(Student("Vemula Kusumakar", 101, 5000, 95000))
        self.students.append(Student("Dokula Charan", 102, 50000, 50000))
        self.students.append(Student("Vemula Chaitanya", 103, 65000, 35000))

    def view_student_details(self):
        print("\nStudent Details:")
        for student in self.students:
            print(f"Name Of Student: {student.get_name()}")
            print(f"Roll Number: {student.get_roll_number()}")
            print(f"Total Fees Paid: Rs {student.get_total_fees_paid()}")
            print(f"Total Fees Due: Rs {student.get_total_fees_due()}")
            print("------------------------------")

    def pay_fees(self):
        try:
            roll_number = int(input("Enter your roll number: "))
        except ValueError:
            print("Invalid roll number format.")
            return

        for student in self.students:
            if student.get_roll_number() == roll_number:
                print(f"Hello, {student.get_name()}!")
                print(f"Your total fees due: Rs {student.get_total_fees_due()}")

                try:
                    payment_amount = float(input("Enter the amount you want to pay Rs: "))
                except ValueError:
                    print("Invalid payment amount.")
                    return

                if payment_amount <= student.get_total_fees_due():
                    student.pay_fees(payment_amount)
                    print("Payment successful!")
                    print(f"Total fees paid: Rs {student.get_total_fees_paid()}")
                    print(f"Remaining fees: Rs {student.get_total_fees_due()}")
                else:
                    print("Invalid amount. Please enter an amount less than or equal to the total fees due.")
                return

        print(f"Student with roll number {roll_number} not found.")

    def run(self):
        while True:
            print("\nExamination Branch [FEES MANAGEMENT] Menu:")
            print("1. View Student Details")
            print("2. Pay College Fees")
            print("3. Exit")

            choice = input("Enter your choice: ")
            if choice == "1":
                self.view_student_details()
            elif choice == "2":
                self.pay_fees()
            elif choice == "3":
                print("The server closed successfully.")
                break
            else:
                print("Invalid option, please provide a valid option.")


if __name__ == "__main__":
    system = FeesManagementSystem()
    system.run()
