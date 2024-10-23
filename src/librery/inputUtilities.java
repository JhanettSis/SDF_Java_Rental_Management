/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librery;
import java.sql.ResultSet;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
/**
 *
 * @author jhanett
 */
public class inputUtilities {
    /**
     * The code defines a function named printTable that takes a ResultSet object 
     * 
     * @param rs (database query result) as input
     * @throws SQLException potentially throws a SQLException (database exception). 
     * The function formats and prints the contents of the result set as a table to the console.
     */
    public static void printTable(ResultSet rs) throws SQLException {
        // Get column names and metadata
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        int i, j;
            // Print column headers
            for (i = 1; i <= columnCount; i++) {
                System.out.print("| " + padRight(metaData.getColumnLabel(i), 15) + " "); // Adjust padding with 15
            }
            System.out.println("|");
            printLine(columnCount, '-'); // Print a separator line

            // Print table rows
            while (rs.next()) {
                for (j = 1; j <= columnCount; j++) {
                    System.out.print("| " + padRight(rs.getString(j), 15) + " "); // Adjust padding as needed
                }
                System.out.println("|");
            }
        printLine(columnCount, '-'); // Print a separator line
    }

    /**
     * Purpose: Creates a horizontal line of dashes and a plus sign at the beginning and end.
     * @param columnCount Number of columns (determines line width)
     * @param ch Character to use for filling the line (usually a dash '-')
     * Uses nested loops (i and j) to iterate for the number of columns and fill each column with the 
     * specified character (ch) for a set width (adjustable with 17).
     * Output: Prints the constructed line with plus signs at the ends.
     */
    private static void printLine(int columnCount, char ch) {
        int i, j;
        for (i = 0; i < columnCount; i++) {
            System.out.print("+");
            for (j = 0; j < 17; j++) { // Adjust length based on column width and padding
                System.out.print(ch);
            }
        }
        System.out.println("+");
    }
    /**
     * Function: padRight takes two arguments: a string (s) and an integer (n).
     * Padding: 
     * 
     * @param s Indicates that the argument should be treated as a string.
     * If the input string (s) is null, 
     * it replaces it with "NULL" before padding.
     * @param n This is a variable that specifies the width of the resulting string. 
     * If s is shorter than n characters, spaces will be added to 
     * the right of s until it reaches n characters in length.
     * @return Formats a string s to left-justify within width n, padding with spaces.
     */
    private static String padRight(String s, int n) {
        if (s == null) {
            s = "NULL";
        }
        return String.format("%1$-" + n + "s", s);
    }
    
    /**
     * Ask user to enter some  text - if they enter non-text (like numbers)
     * then ask them again
     * @param prompt - the question or prompt to ask the user
     * @return a String containing whatever text the user entered
     */
    public String askUserForText(String prompt){
        
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        
        do{
            System.out.println(prompt);
            System.out.println("     ◘ Enter text only please - no numbers!");
            userInput = myScanner.nextLine();
                        
        }while(!userInput.matches("[a-zA-Z! ]+"));
        
        return(userInput);
        
    }
    
    /**
     * Ask the user to enter any integer value (negatives are allowed)
     * if they do not enter an integer ask them again
     * @param prompt the question or prompt to ask the user
     * @return a valid int entered by the user
     */
    public int askUserForInt (String prompt){
        
        Scanner myScanner = new Scanner(System.in);
        String myNumber;
        
        do{
            System.out.println(prompt);
            System.out.println("     ◙ Insert a integer number please!");
            myNumber = myScanner.nextLine();
        }while(!myNumber.matches("[0-9]+"));
        
        int userInt = Integer.parseInt(myNumber);
        return(userInt);
    }
    /**
     * This function prompts the user to enter a date in "YYYY-MM-dd" format,
     * repeatedly asking until a valid date is provided. 
     * It parses the input using a DateTimeFormatter, 
     * handles invalid formats, and returns the valid date as a string.
     * @param prompt indicates a placeholder for method documentation, explaining the input parameter.
     * @return  statement returns the valid date string entered by the user, 
     * formatted as "YYYY-MM-dd".
     */
    public String askForDate(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String dateString = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (dateString == null) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                LocalDate date = LocalDate.parse(input, formatter);
                dateString = date.toString(); // Convert LocalDate back to string
            } catch (DateTimeParseException e) {
                System.out.println("     ◙ Invalid date format. Please try again.");
            }
        }

        return dateString;
    }
    
    
}