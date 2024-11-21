import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class subscriber {
    String name;
    String address;
    String email;
    String credit_card;
    String exp_date;
    String plan_type = "Free";
    String frequency = "Monthly";
    static double free_fees = 0;
    static double optimized_fees = 4.99;
    static double platinum_fees = 9.99;
    static double on_theatre_movies = 1.99;
    int no_theater_movies;

    int pin;
    int code;

    subscriber() {}
/*
    subscriber(String s_name, String s_email, String s_credit_card, String s_exp_date) {
        name = s_name;
        email = s_email;
        credit_card = s_credit_card;
        exp_date = s_exp_date;
    }
    static void display_plans() {
        System.out.println(" The Free plan is is free of charge, therefore, you will be charged $" + free_fees + ". The Platinum plan is $" + platinum_fees + " per month, and if paid annually, it will become $" + (platinum_fees * 2 * 0.80) + " and if paid semi-annually, it will be $" + (platinum_fees * 0.85 * 6) + ". The Optimized plan is $" + optimized_fees + " per month and if you paid annually this becomes $" + (optimized_fees * 12 * 0.75) + " if you paid semi annually it should be $" + (optimized_fees * 6 * 0.80));
    }

    void change_plan(String new_frequency, String new_plan) {
        frequency = new_frequency;
        plan_type = new_plan;
        if (new_frequency.equalsIgnoreCase("Annual") && new_plan.equalsIgnoreCase("Optimized")) {
            System.out.println(" we are going to charge your card $" + (optimized_fees * 12 * 0.75));
        } else {
            System.out.println(" the free plan is out charge");
        }
    }

    void display_monthly_bill(int no_theater_movies) {
        double bill = no_theater_movies * on_theatre_movies;
        if (frequency.equalsIgnoreCase("monthly")) {
            if (plan_type.equalsIgnoreCase("Optimized")) bill += optimized_fees;
            else if (plan_type.equalsIgnoreCase(("Platinum"))) bill += platinum_fees;
            else bill += 0;
        }
        System.out.println(name + " Your monthly bill is $" + bill + ", and with tax it is $" + (bill * 1.06) + ", and your current plan is " + plan_type);
    }*/

    subscriber(String new_name,String new_address, String new_email,String new_credit_card,String new_exp_date,int new_pin) {
        name=new_name;
        email = new_email;
        credit_card = new_credit_card;
        exp_date = new_exp_date;
        pin=new_pin;
        address=new_address;}
    static void display_plans() {
        System.out.println(" The Free plan is is free of charge, therefore, you will be charged $" + free_fees + ". The Platinum plan is $" + platinum_fees + " per month, and if paid annually, it will become $" + (platinum_fees * 2 * 0.80) + " and if paid semi-annually, it will be $" + (platinum_fees * 0.85 * 6) + ". The Optimized plan is $" + optimized_fees + " per month and if you paid annually this becomes $" + (optimized_fees * 12 * 0.75) + " if you paid semi annually it should be $" + (optimized_fees * 6 * 0.80));
    }

    void change_plan(String new_frequency, String new_plan) {
        frequency = new_frequency;
        plan_type = new_plan;
        if (new_frequency.equalsIgnoreCase("Annual") && new_plan.equalsIgnoreCase("Optimized")) {
            System.out.println(" we are going to charge your card $" + (optimized_fees * 12 * 0.75));
        } else {
            System.out.println(" the free plan is out charge");
        }
    }

    void display_monthly_bill(int no_theater_movies) {
        double bill = no_theater_movies * on_theatre_movies;
        if (frequency.equalsIgnoreCase("monthly")) {
            if (plan_type.equalsIgnoreCase("Optimized")) bill += optimized_fees;
            else if (plan_type.equalsIgnoreCase(("Platinum"))) bill += platinum_fees;
            else bill += 0;
        }
        System.out.println(" Your monthly bill is $" + bill + ", and with tax it is $" + (bill * 1.06) + ", and your current plan is " + plan_type+frequency);
    }

    public static int get6_dig_Pin(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter your 6 digit numerical pin: ");
                int pin = scanner.nextInt();
                if (pin >= 100000 && pin <= 999999) {
                    System.out.println("Security code and Pin successfully entered! ");
                    return pin;
                } else {
                    System.out.println("Pin must be a 6-digit numerical value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numerical value.");
                scanner.nextLine();
            }
        }
    }
}


