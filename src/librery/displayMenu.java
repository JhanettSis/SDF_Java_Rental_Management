/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librery;


public class displayMenu {
    /**
     * This function msgWelcome() just displays a welcome message.
     */
    public static void msgWelcome(){
        System.out.println("♥****************************************************************************************************************♥");
        System.out.println("                                  Welcome to the System Rent!");
        System.out.println("♥****************************************************************************************************************♥");
    }
    
    /**
     * This function listMenu() displays a menu with various options to the user. 
     * Each option is numbered and describes a specific action that can be taken.
     * 
     */
    public static void listMenu() {
        System.out.println("♥☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼♥");
        System.out.println("                                        Menu Options");
        System.out.println("♥☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼♥");
        System.out.println("    • Press 1. Retrieve all clients along with their associated properties.");
        System.out.println("    • Press 2. List all properties rented out by all clients whose name begins with...");
        System.out.println("    • Press 3. List all clients who have properties rented out for a specific duration.");
        System.out.println("    • Press 4. Calculate the total monthly rent for each client.");
        System.out.println("    • Press 5. Find the owner of a specific property.");
        System.out.println("    • Press 6. Count the total number of properties owned by each owner.");
        System.out.println("    • Press 7. Identify clients who own multiple properties.");
        System.out.println("    • Press 8. List all clients along with the total rent they pay annually, sorted in ascending order.");
        System.out.println("    • Press 9. Find the client who pays the highest monthly rent.");
        System.out.println("    • Press 10. List all properties with rent amounts greater than the average rent amount across all properties.");
        System.out.println("    • Press 0. Exit");
        System.out.println("♥☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼♥");
        System.out.print("      ■  Select an option: ");
    }
    /**
     * This function prints a box with a message saying 
     * "You pressed the option" followed by the number you entered (value).
     * @param value the number entered by the user 
     * it is displayed indicating which option was chosen by the user.
     */
    public static void messageOption(int value){
        System.out.println("┌┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┐");
        System.out.println("                                      You chose option "+value);   
        System.out.println("└┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┘");
    }
    /**
     * This function prints a message to the console when the user selects option 0. 
     * It includes a fancy border and says goodbye to the user.
     */
    public static void messageForOption0(){
        System.out.println("┌┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┬┐");
        System.out.println("                                      You chose option 0 ");   
        System.out.println("                                Thank you for viviting and Good bye!! ");   
        System.out.println("└┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┴┘");
    }
    
}
