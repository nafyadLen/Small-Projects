
public class Lenjiso_FoodBill {
    public static void main(String[] args) {
        String greetings = " Hello My name is John, I am glad I am here, Thank you !! ";
        greetings=greetings.trim();
        System.out.println("Who are you?" + greetings);
        System.out.println("Who are you?" + greetings.trim());
        System.out.println("Who are you?" + greetings.toUpperCase());
        System.out.println("Who are you?" + greetings.toLowerCase());
        System.out.println(greetings.trim().endsWith("!"));
        System.out.println(greetings.trim().startsWith("H"));
        System.out.println(greetings.contains("Thank  you"));
        System.out.println(greetings.trim().indexOf("Thank  you"));
        short y=100;
        int x=500;
        System.out.println(x);
        x-=50; //x=x-50
        System.out.println(x);
        x=x+1;
        x+=1;
        x++; // is x+1
        System.out.println(x);
        x=y;
        x=(short)x;


        System.out.println(Math.ceil(5.00000002));



    }
}