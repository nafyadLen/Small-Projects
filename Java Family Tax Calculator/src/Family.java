public class Family {
    double number_members;
    String family_surname;
    double family_annual_income;
    String current_address;

public static int calculate_tax_credit(int no_kids_under6){
    System.out.println("your tax credit is"+no_kids_under6*2500);
}
public void calculate_tax_relief(double family_annual_income1, double number_members1)
    {
        number_members=number_members1;
        family_annual_income=family_annual_income1;
        double tax_relief=family_annual_income1-12,500*number_members1;
        System.out.println(family_annual_income1-tax_relief);
    }
}
