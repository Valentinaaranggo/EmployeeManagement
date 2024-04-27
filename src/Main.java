import java.util.*;
import java.sql.*;
import java.lang.StringBuilder;
import static java.lang.System.out;

public class Main {

    static Scanner scnr = new Scanner(System.in);

    public static Connection buildConnection() {
        String url = "jdbc:mysql://localhost:3306/employeeData";
        String user = "root";
        String password = "";

        Connection myConn = null; // Declare myConn outside the try block

        try {
            myConn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }

        return myConn;
    }

    public static void changeTable() {
        out.println("\nWhat column would you like to add?");
        String columnName = scnr.nextLine().trim();

        out.println("\nWhat's the data type?");
        String dataType = scnr.nextLine().trim();

        ChangeTable tableChanger = new ChangeTable();
        Connection myConn = buildConnection();

        tableChanger.addColumn(columnName, dataType, myConn);
    }

    public static void updateEmployeeSalary() {

        System.out.println("\nPlease enter the percentage increase:");
        double increasePercentage = scnr.nextDouble();
        System.out.println("\nEnter the minimum salary:");
        double minSalary = scnr.nextDouble();
        System.out.println("\nEnter the maximum salary:");
        double maxSalary = scnr.nextDouble();

        UpdateEmployee updater = new UpdateEmployee();

        Connection myConn = buildConnection();
        updater.updateEmployeeSalary(increasePercentage, minSalary, maxSalary, myConn);
    }

    public static void searchEmployee() {
        out.println("\nPlease enter the employee's first name:");
        String fname = scnr.nextLine().trim();
        out.println("\nPlease enter the employee's last name:");
        String lname = scnr.nextLine().trim();
        out.println("\nPlease enter the employee's ID:");
        int empID = scnr.nextInt();
        out.println("\nPlease enter the employee's SSN:");
        int ssn = scnr.nextInt();

        SearchEmployee search = new SearchEmployee();
        Connection myConn = buildConnection();
        search.search(fname, lname, empID, ssn, myConn);

    }

    public static void updateEmployeeData() {
        System.out.println("\nPlease enter the employee's ID:");
        int empID = scnr.nextInt();
        scnr.nextLine();
        System.out.println("\nWhich column would you like to update? (e.g., Fname, Lname, email)");
        String columnName = scnr.next();
        scnr.nextLine();
        System.out.println("\nEnter the new value for " + columnName + ":");
        String newValue = scnr.nextLine();

        UpdateEmployee updater = new UpdateEmployee();
        Connection myConn = buildConnection();
        updater.updateEmployeeData(columnName, newValue, empID, myConn);
    }

    public static void chooseFunction(String userChoice) {
        switch (userChoice) {
            case "1":
                changeTable();
                break;
            case "2":
                updateEmployeeSalary();
                break;
            case "3":
                updateEmployeeData();
                break;
            case "4":
                searchEmployee();
                break;
            default:
                System.out.println("\nInvalid choice was selected.");
                System.out
                        .println("Please select one of the options listed above by choosing the corresponding number.");
                getUserChoice(); // Loop back to get a valid choice
                break;
        }
    }

    public static void getUserChoice() {
        String userChoice = scnr.nextLine().trim();
        chooseFunction(userChoice);
    }

    public static void presentOptions() {

        String str1 = "\nWelcome to the Employee Management application! Your options are:";
        String str2 = "\n1. Change table";
        String str3 = "\n2. Update employee salary";
        String str4 = "\n3. Update employee data";
        String str5 = "\n4. Search for an employee";
        String str6 = "\n\nWhat would you like to do?";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append(str4);
        stringBuilder.append(str5);
        stringBuilder.append(str6);

        String introMessage = stringBuilder.toString();

        out.println(introMessage);
        getUserChoice();

    }

    public static void main(String[] args) {

        presentOptions();

    }
}
