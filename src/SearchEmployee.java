import java.sql.*;

public class SearchEmployee {
    public void search(String fname, String lname, int empID, Connection myConn)
    {
        String sql = String.format("SELECT * FROM employees WHERE Fname='%s' AND Lname='%s' AND empid='%d%n';", fname, lname, empID);
        StringBuilder output = new StringBuilder("");
        try {
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery(sql);
            if (rs.next())
            {
                output.append("\nEmployee ID: "+ rs.getInt("empid") +
                "\nName: " + rs.getString("Fname") + " " + rs.getString("Lname") +
                "\nEmail: " + rs.getString("email") +
                "\nHire Date: " + rs.getDate("HireDate") +
                "\nSalary: " + rs.getInt("Salary"));
                System.out.println(output.toString());
                System.out.println("\nSearch successful! What would you like to do next?\n1. Search again \n2. Go back to home page");
                Main.scnr.nextLine();
                getUserChoice();
            } else {
                System.out.println("\nEmployee was not found. Please try again.");
                Main.scnr.nextLine();
                Main.searchEmployee();
            }
            myConn.close();
        }catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
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
                Main.searchEmployee();
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
