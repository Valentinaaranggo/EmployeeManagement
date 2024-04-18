package EmployeeManagement;
import java.util.*;
import java.sql.*;
import java.lang.StringBuilder;
import static java.lang.System.out;
import EmployeeManagement.ChangeTable;
import EmployeeManagement.UpdateEmployeeData;
import EmployeeManagement.UpdateEmployeeSalary;
import EmployeeManagement.SearchEmployee;

public class Main {

    static Scanner scnr = new Scanner(System.in);

    public static Connection buildConnection () {
        String url = "jdbc:mysql://localhost:3306/employeeData";
        String user = "root";
        String password = "";

        Connection myConn = null; // Declare myConn outside the try block

        try {
            myConn = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }

        return myConn;
    }

    public static void changeTable () {
        out.println("\nWhat column would you like to add?");
        String columnName = scnr.nextLine().trim();

        out.println("\nWhat's the data type?");
        String dataType = scnr.nextLine().trim();

        ChangeTable tableChanger = new ChangeTable();
        Connection myConn = buildConnection();

        tableChanger.addColumn(columnName, dataType, myConn);
    }

    public static void updateEmployeeSalary () {

    }

    public static void searchEmployee () {

    }

    public static void updateEmployeeData () {
        
    }

    public static void chooseFuntion (String userChoice) {
        switch (userChoice.toLowerCase()) {
            case "change table":
                changeTable();
                break;
            case "update employee table":
                updateEmployeeSalary();
                break;
            case "update employee data":
                searchEmployee();
                break;
            case "search for an employee":
                updateEmployeeData();
                break;
            default:
                System.out.println("\nA wrong choice was provided");
                System.out.println("Please select one of the options listed above");
                getUserChoice(); // Loop back to get a valid choice
                break;
        }
    }

    public static void getUserChoice(){
        String userChoice = scnr.nextLine().trim();
        chooseFuntion(userChoice);
    }

    public static void presentOptions () {

        String str1 = "Welcome to the Employee Management application! Your options are:";
        String str2 = "\nChange table";
        String str3 = "\nUpdate employee ealary";
        String str4 = "\nUpdate employee eata";
        String str5 = "\nSearch for an employee";
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
