import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner my_scanner = new Scanner(System.in);
       /* subscriber s_ken=new subscriber("Ken","ken1@howard.edu","12345678910","05/28");
        subscriber.display_plans();
        //Ken's Bill and subscription
        s_ken.change_plan("monthly","Optimized");
        s_ken.display_monthly_bill(2);
        //Anayah's Bill and subscription
        subscriber s_Anayah=new subscriber("Anayah", "address", "Anayah@howard.edu","8945634870","09/29");
        s_Anayah.change_plan("semi_annual","Platinum");
        s_Anayah.display_monthly_bill(4);
        //ask for 6 digit numericak pin*/
        System.out.println(" What is your name? ");
        String new_name=my_scanner.nextLine();
        System.out.println(" What is your address? ");
        String new_address=my_scanner.nextLine();
        System.out.println(" Your email?");
        String new_email=my_scanner.nextLine();
        System.out.println(" Your credit card number?");
        String new_credit_card=my_scanner.nextLine();
        System.out.println(" Your credit card expiry date?");
        String new_exp_date=my_scanner.nextLine();
        System.out.println(" Enter your security code:");
        int new_code=my_scanner.nextInt();
        my_scanner.nextLine();
        System.out.println(" What plan type? ");
        String new_plan=my_scanner.nextLine();
        System.out.println(" How do you want to pay? ");
        String new_frequency=my_scanner.nextLine();
        System.out.println(" How many in-theater movies did you watch this month?");
        int on_theatre_movies=my_scanner.nextInt();
        //calculate and display
        subscriber subs_new=new subscriber();
        subscriber.display_plans();
        subs_new.change_plan(new_frequency, new_plan);
        subs_new.display_monthly_bill(on_theatre_movies);
        System.out.println(" Enter your 6 digit pin number:");
        int pin = subscriber.get6_dig_Pin(my_scanner);





    }

}