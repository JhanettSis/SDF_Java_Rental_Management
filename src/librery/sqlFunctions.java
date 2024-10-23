/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author jhanett
 */
public class sqlFunctions {
    private static final String URL = "jdbc:mysql://localhost:3306/RentManagement";
    private static final String USER = "root";
    private static final String PASSWORD = "Test234*";
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    } 
    
    /**
     * This function retrieves information about clients and their properties from a database. 
     * It joins three tables: Clients, Client_Properties, and Properties. 
     * It then displays the data in a table format.
     * @throws SQLException 
     * It joins the three tables based on client number (Client_No) and property number (PropertyNo).
     * It executes the query and retrieves the results in a ResultSet.
     * Finally, it uses an inputUtilities class to print the results as a table.
     */
    public static void  retrieveAllClientsWithProperties() throws SQLException {
        String query = "SELECT Clients.Client_No, Clients.Client_name as Name, "
                + "Properties.PropertyNo, Properties.Property_Address as Address, "
                + "Client_Properties.Rent_Start, Client_Properties.Rent_Finish " +
                "FROM Clients " +
                "JOIN Client_properties ON Clients.Client_No = Client_properties.Client_No " +
                "JOIN Properties ON Client_properties.PropertyNo = Properties.PropertyNo ";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
                inputUtilities.printTable(rs);
        }
    }
    /**
     * This function, named listPropertiesRentedByClients, takes a client name as input. 
     * It retrieves a list of properties rented by that client, along with some details.
     * The query searches for clients whose name matches the input clientName (using LIKE with a wildcard %).
     * @param clientName
     * @throws SQLException
     * The function uses a PreparedStatement to prevent SQL injection vulnerabilities.
     * It iterates through the query results and prints them in a table format using an 
     * inputUtilities.printTable method 
     */
    public static void listPropertiesRentedByClients(String clientName) throws SQLException {
        String query = "SELECT Clients.Client_No, Clients.Client_Name, Properties.PropertyNo, Properties.Property_Address, "
                + "Client_Properties.rent_start " +
                "FROM Clients " +
                "JOIN Client_properties ON Clients.Client_No = Client_properties.Client_No " +
                "JOIN Properties ON Client_properties.PropertyNo = Properties.PropertyNo " +
                "WHERE Clients.Client_Name LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, clientName + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                inputUtilities.printTable(rs);
            }
        }
    }
    
    /**
     * This function, named listClientsWithPropertiesForDuration, takes a start date and end date as strings.
     * It then retrieves a list of clients and their properties that fall 
     * @param startDate the provided startDate is on or before the provided endDate.
     * @param endDate the provided Rent_Finish is on or after the provided startDate.
     * @throws SQLException 
     * It uses a PreparedStatement to prevent SQL injection vulnerabilities.
     * It replaces placeholders (?) in the query with the actual startDate and endDate.
     */
    public static void listClientsWithPropertiesForDuration(String startDate, String endDate) throws SQLException {
        String query = "SELECT Clients.Client_No, Clients.Client_Name, "
                + "Client_Properties.Rent_Start, Client_Properties.Rent_finish " +
                "FROM Clients " +
                "JOIN Client_properties ON Clients.Client_No = Client_properties.Client_No " +
                "WHERE Client_properties.Rent_start >= ? AND Client_properties.Rent_finish <= ? ";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, startDate);
            pstmt.setString(2, endDate);
            try (ResultSet rs = pstmt.executeQuery()) {
                inputUtilities.printTable(rs);
            }
        }
    }
    

    /**
     * This function calculates the total monthly rent paid by each client.
     * @throws SQLException 
     * It retrieves data from three tables: Clients, Client_Properties, and Properties.
     * It joins them based on Client number and Property number.
     * It groups the results by Client number and name.
     * It calculates the sum of monthly rent for each client.
     * Finally, it displays a table showing Client number, name, and total monthly rent.
     */
    public static void calculateTotalMonthlyRentForEachClient() throws SQLException {
        String query = "SELECT Clients.Client_No, Clients.Client_Name, SUM(Properties.Monthly_rent) AS Total_Monthly_Rent " +
                "FROM Clients " +
                "JOIN Client_properties ON Clients.Client_No = Client_properties"
                + ".Client_No " +
                "JOIN Properties ON Client_properties.PropertyNo = Properties.PropertyNo " +
                "GROUP BY Clients.Client_No, Clients.Client_Name";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            inputUtilities.printTable(rs);
        }
    }
    
    /**
     * This function searches for the owner of a property. 
     * It takes a property address as input (with wildcard for partial matches) and:
     * Creates a SQL query to join two tables: "Properties" and "Owners".
     * @param propertyName Matches properties where the address partially matches the input.
     * @throws SQLException 
     * Selects owner name, property number, and address.
     * Executes the query safely using a PreparedStatement.
     * Prints the results in a table format if any rows are found.
     */   
    public static void findOwnerOfProperty(String propertyName) throws SQLException {
        String query = "SELECT Owners.Owner_Name, Properties.PropertyNo, Properties.Property_Address " +
                "FROM Properties " +
                "JOIN Owners ON Properties.Owner_No = Owners.Owner_No " +
                "WHERE Properties.Property_Address LIKE ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, propertyName + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                inputUtilities.printTable(rs);
            }
        }
    }
    /**
     * This function counts properties owned by a specific owner based on their name.
     * It uses a SQL query to join Owners and Properties tables on the Owner_No.
     * The WHERE clause searches for owners with names LIKE the provided name (using wildcard search).
     * The query groups results by owner and counts the number of properties for each using COUNT.
     * It prepares a statement to prevent SQL injection vulnerabilities and executes the query.
     * The function likely uses an inputUtilities.printTable function to display the results in a tabular format.
     * @param ownerName from the main user send a text.
     * @throws SQLException 
     */        
    public static void countPropertiesOwnedByOwner(String ownerName) throws SQLException {
        String query = "SELECT Owners.Owner_No, Owners.Owner_Name, COUNT(Properties.PropertyNo) AS No_of_Property " +
                "FROM Owners " +
                "JOIN Properties ON Owners.Owner_No = Properties.Owner_No " +
                "WHERE Owners.Owner_Name LIKE ? " +
                "GROUP BY Owners.Owner_No, Owners.Owner_Name";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, ownerName + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                inputUtilities.printTable(rs);
            }
        }
    }
    
    /**
     * It likely connects to a database (using SQLException) to find clients 
     * who have rented more than propertyCount properties.
     * @param propertyCount This function takes an integer propertyCount as input. 
     * @throws SQLException 
     */  
    public static void identifyClientsWithMultipleProperties(int propertyCount) throws SQLException {
        String query = "SELECT Clients.Client_No, Clients.Client_Name, COUNT(Client_properties.PropertyNo) AS Rented_Properties " +
                "FROM Clients " +
                "JOIN Client_properties ON Clients.Client_No = Client_properties.Client_No " +
                "GROUP BY Clients.Client_No, Clients.Client_Name " +
                "HAVING Rented_Properties >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, propertyCount);
            try (ResultSet rs = pstmt.executeQuery()) {
                inputUtilities.printTable(rs);
            }
        }
    }
    /**
     * This function calculates the total annual rent for each client.
     * Query: It builds a complex SQL statement to join three tables: Clients, Client_properties, and Properties.
     * It calculates annual rent by multiplying the sum of monthly rent by 12.
     * It uses a try-with-resources block to safely execute the query and close connections.
     * @throws SQLException This indicates the function might encounter database errors.
     */
    public static void listClientsWithTotalAnnualRent() throws SQLException {
        String query = "SELECT Clients.Client_No, Clients.Client_Name, SUM(Properties.Monthly_rent) * 12 AS Annual_Rent " +
                "FROM Clients " +
                "JOIN Client_properties ON Clients.Client_No = Client_properties.Client_No " +
                "JOIN Properties ON Client_properties.PropertyNo = Properties.PropertyNo " +
                "GROUP BY Clients.Client_No, Clients.Client_Name " +
                "ORDER BY Annual_Rent ASC";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            inputUtilities.printTable(rs);
        }
    }
    /**
     * It builds a complex SQL query to achieve the goal.
     * The query joins three tables: Clients, Client_Properties, and Properties.
     * It finds the maximum Rent_Start date for each client in Client_Properties.
     * Then, it selects clients whose Rent_Start matches the maximum for each client.
     * Finally, it groups by client, finds the maximum monthly rent for each client, 
     * and orders by highest rent descending, limiting the result to 1 (top client).
     * @throws SQLException It throws an SQLException if a database error occurs.
     */
    public static void findClientWithHighestMonthlyRent() throws SQLException {
        String query = "SELECT Clients.Client_No, Clients.Client_Name, MAX(Properties.Monthly_rent) AS Highest_Monthly_Rent " +
                "FROM Clients " +
                "JOIN Client_properties ON Clients.Client_No = Client_properties.Client_No " +
                "JOIN Properties ON Client_properties.PropertyNo = Properties.PropertyNo "
                + "WHERE Client_Properties.Rent_Start = ( "
                + "SELECT MAX(Rent_Start) "
                + "FROM Client_Properties AS cp2 "
                + "WHERE cp2.Client_No = Client_Properties.Client_No) " +
                "GROUP BY Clients.Client_No, Clients.Client_Name " +
                "ORDER BY Highest_Monthly_Rent DESC LIMIT 1";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            inputUtilities.printTable(rs);
        }
    }
    /**
     * The function finds properties with rent exceeding the average rent.
     * It queries the Properties table for property number, address, and monthly rent.
     * The query uses a sub query to calculate the average monthly rent from the same table.
     * It then selects properties where the rent is greater than or equal to the average.
     * Finally, it prints the results in a table
     * @throws SQLException if there's a database error.
     */
    public static void listPropertiesWithRentGreaterThanAverage() throws SQLException {
        String query = "SELECT PropertyNo, Property_Address, Monthly_rent  "
                + "FROM Properties " +
                "where Monthly_Rent >= (SELECT AVG(Monthly_Rent) FROM Properties)";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            inputUtilities.printTable(rs);
        }
    }
    
  
    
}
