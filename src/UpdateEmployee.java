
import java.sql.*;

public class UpdateEmployee {
    public void updateEmployeeData(String columnName, String newValue, int empID, Connection myConn) {
        String sqlCommand = String.format("UPDATE employees SET %s = '%s' WHERE empID = %d", columnName, newValue,
                empID);
        try {
            Statement myStmt = myConn.createStatement();

            int rowsAffected = myStmt.executeUpdate(sqlCommand);
            if (rowsAffected > 0) {
                System.out.println(
                        "\nUpdate successful! What would you like to do next?\n1. Update another column \n2. Go back to home page");
                getUserChoice();
            } else {
                System.out.println("Column not found or update failed. Please try again.");
            }

            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }

    public void updateEmployeeSalary(double increasePercentage, double minSalary, double maxSalary, Connection myConn) {
        String sqlCommand = String.format(
                "UPDATE employees SET Salary = Salary * (1 + %.2f/100) WHERE Salary >= %.2f AND Salary < %.2f",
                increasePercentage, minSalary, maxSalary);
        try {
            Statement myStmt = myConn.createStatement();
            myStmt.executeUpdate(sqlCommand);
            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }

    public static void getUserChoice() {
        String choice = Main.scnr.nextLine().trim();
        chooseFunction(choice);
    }

    public static void chooseFunction(String userChoice) {
        switch (userChoice) {
            case "1":
                Main.updateEmployeeData();
                break;
            case "2":
                Main.presentOptions();
                break;
            default:
                System.out.println("\nInvalid choice was selected.");
                System.out
                        .println("Please select one of the options listed above by choosing the corresponding number.");
                getUserChoice();
                break;
        }
    }

}
