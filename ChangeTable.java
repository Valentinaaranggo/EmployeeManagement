package EmployeeManagement;
import java.sql.*;
import static java.lang.System.out;
public class ChangeTable {
    
    public void addColumn (String columnName, String dataType, Connection myConn1) {
        String sqlcommand1 = String.format("ALTER TABLE employees ADD %s %s;", columnName, dataType);
        try {
            Statement myStmt = myConn1.createStatement();
            myStmt.executeUpdate(sqlcommand1);
            myConn1.close();
            out.println("\nColumn created successfully.");
        }catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } finally {
        }
    }
}