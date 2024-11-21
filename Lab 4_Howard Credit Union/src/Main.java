/*
Name: Nafyad Lenjiso
Today is 09/19/2023, and I am feeling good
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner my_Scanner = new Scanner(System.in);
        double min_installment = 5000.0 / 3.0;

        for (int i = 1; i <= 4; i++) {
            System.out.println("Welcome to Howard University CREDIT UNION.");
            System.out.println("What is Your name?");
            String studentname = my_Scanner.nextLine();
            System.out.println("What is your credit score?");
            int studentcredit = my_Scanner.nextInt();
            my_Scanner.nextLine();

            if (studentcredit > 570) {
                System.out.println("What is your monthly income?");
                double studentincome = my_Scanner.nextDouble();
                my_Scanner.nextLine();
                double total_expense = 0;
                boolean flag = true;

                while (flag) {
                    System.out.println("What is this expense?");
                    String expense_type = my_Scanner.nextLine();
                    System.out.println("How much is this expense?");
                    double expense_amount = my_Scanner.nextDouble();
                    my_Scanner.nextLine();
                    total_expense += expense_amount;
                    System.out.println("Would you like to add another expense?");
                    String applicant_answer = my_Scanner.nextLine();
                    if (applicant_answer.equals("no")) {
                        flag = false;
                    }
                }

                double left_over = studentincome - total_expense;
                System.out.println("You have $" + left_over + " left");

                if (left_over >= min_installment) {
                    System.out.println("You can apply");
                } else {
                    System.out.println("You don't make enough money");
                }
            } else {
                System.out.println(studentname+" your credit is not approved");
            }
        }
    }
}