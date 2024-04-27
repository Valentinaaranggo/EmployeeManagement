
import java.sql.*;
public class ChangeTable {
    
    public void addColumn (String columnName, String dataType, Connection myConn1) {
        String sqlcommand1 = String.format("ALTER TABLE employees ADD %s %s;", columnName, dataType);
        try {
            Statement myStmt = myConn1.createStatement();
            myStmt.executeUpdate(sqlcommand1);
            System.out.println("\nChange successful! What would you like to do next?\n1. Make another change\n2. Go to home page");
            getUserChoice();
            myConn1.close();
        }catch (Exception e) {
            System.out.println("\nPlease try again with valid inputs.");
            Main.changeTable();
        } finally {
        }
    }

    public static void getUserChoice() {
        String choice = Main.scnr.nextLine().trim();
        chooseFunction(choice);
    }
    
    public static void chooseFunction (String userChoice) {
        switch (userChoice) {
            case "1":
                Main.changeTable();
                break;
            case "2":
                Main.presentOptions();
                break;
            default:
                System.out.println("\nInvalid choice was selected.");
                System.out.println("Please select one of the options listed above by choosing the corresponding number.");
                getUserChoice();
                break;
        }
    }
}