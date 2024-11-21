import javax.swing.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter you Student ID");
        try {
            String id = scan.nextLine();
            Connection con = DB.connect_DB_MY_SQL();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from students where studentID>" + id);

            System.out.println(rs.getString("StudentName"));
        } catch (InputMismatchException e) {
            System.out.println("enter a valid ID");
        } catch (SQLException s) {

            System.out.println(" we failed to connect the database");
        } finally {
            System.out.println("thanks for visiting us");
        }
    }
}

