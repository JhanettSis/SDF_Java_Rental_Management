/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rentmanagementca;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
import librery.displayMenu;
import librery.inputUtilities;
import librery.sqlFunctions;
/**
 *
 * @author jhanett
 */
public class RentManagementCA {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        displayMenu.msgWelcome();
        Scanner myScanner = new Scanner(System.in);
        Connection conn = sqlFunctions.getConnection();
        boolean isFinish = false;
        String option;
        /**
         * Loop Condition: The loop (do { ... } while (isFinish != true);) 
         * continues until isFinish is set to true.
         */
        do {
            /**
             * Display Menu: displayMenu.listMenu(); 
             * calls a method to display the menu options to the user.
             */
            displayMenu.listMenu();
            option = myScanner.nextLine();
            /**
             * inputUtilities
             * creates an instance of a helper class for input handling.
             */
            inputUtilities myText = new inputUtilities();
            
            try {
                /**
                 * executes corresponding actions based on the user's choice, 
                 * and continues until the user chooses to exit. 
                 */
                switch (option) {
                    case "1": //Calls a method to retrieve all clients with their properties.
                        displayMenu.messageOption(1); //This is just for diplaing a message
                        sqlFunctions.retrieveAllClientsWithProperties();
                        isFinish = false;
                        break;
                    case "2": //Prompts for a client name, then lists properties rented by clients matching that name.
                        displayMenu.messageOption(2); //This is just for diplaing a message
                        String clientName = myText.askUserForText("     ◘ Enter client name or part of a name: ");
                        sqlFunctions.listPropertiesRentedByClients(clientName);
                        isFinish = false;
                        break;
                    case "3": //Prompts for start and end dates, validates them, then lists clients with properties rented during that period.
                        displayMenu.messageOption(3); //This is just for diplaing a message
                        String startDate = myText.askForDate("     ◘ Enter START date (yyyy-mm-dd): ");
                        String endDate = myText.askForDate("     ◘ Enter END date (yyyy-mm-dd): ");
                        LocalDate start = LocalDate.parse(startDate);
                        LocalDate end = LocalDate.parse(endDate);
                            if (start.isBefore(end)) {
                                sqlFunctions.listClientsWithPropertiesForDuration(startDate, endDate);
                            } else {
                                System.out.println("--------------------------  Check  ----------------------");
                                System.out.println("                 ◙ Start date is after End date.");
                                System.out.println("--------------------  Please try again  -----------------");
                            }
                        isFinish = false;
                        break;
                    case "4": // Calculates the total monthly rent for each client.
                        displayMenu.messageOption(4); //This is just for diplaing a message
                        sqlFunctions.calculateTotalMonthlyRentForEachClient();
                        isFinish = false;
                        break;
                    case "5": //Prompts for a property name and finds the owner.
                        System.out.print("     ◘ Enter Address property or part of an Address: ");
                        String propertyName = myScanner.nextLine().trim();
                        sqlFunctions.findOwnerOfProperty(propertyName);
                        isFinish = false;
                        break;
                    case "6": //Prompts for an owner name and counts the properties owned by that owner.
                        displayMenu.messageOption(6); //This is just for diplaing a message
                        String ownerName = myText.askUserForText("     ◘ Enter owner name or part of a name: ");
                        sqlFunctions.countPropertiesOwnedByOwner(ownerName);
                        isFinish = false;
                        break;
                    case "7": //Prompts for a number of properties and identifies clients owning at least that many properties.
                        displayMenu.messageOption(7); //This is just for diplaing a message
                        int propertyCount = myText.askUserForInt("     ◘ Enter number of properties: ");
                        sqlFunctions.identifyClientsWithMultipleProperties(propertyCount);
                        isFinish = false;
                        break;
                    case "8": //Lists all clients along with the total rent they pay annually.
                        displayMenu.messageOption(8); //This is just for diplaing a message
                        sqlFunctions.listClientsWithTotalAnnualRent();
                        isFinish = false;
                        break;
                    case "9": //Finds the client paying the highest monthly rent.
                        displayMenu.messageOption(9); //This is just for diplaing a message
                        sqlFunctions.findClientWithHighestMonthlyRent();
                        isFinish = false;
                        break;
                    case "10": //ists properties with rent amounts greater than the average.
                        displayMenu.messageOption(10); //This is just for diplaing a message
                        sqlFunctions.listPropertiesWithRentGreaterThanAverage();
                        isFinish = false;
                        break;
                    case "0": //Exits the loop by setting isFinish to true.
                        displayMenu.messageForOption0(); //This is just for diplaing a message
                        isFinish = true;
                        break;
                    default: //Handles invalid options with a message.
                        System.out.println("     ◙ Invalid option. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (isFinish != true);
        conn.close(); //Closes the database connection and scanner after the loop ends.
        myScanner.close();
        
    }
    
}
