  <h1>Rental Management System Program Explanation</h1>
    <p>The program is a <span class="highlight">Rental Management System</span> that interacts with a SQL database to manage rental information, clients, and properties. It allows users to perform various tasks like retrieving client data, calculating rents, finding property owners, and more, using a <strong>menu-based system</strong>.</p>
    <h2>1. Imports</h2>
    <ul>
        <li><code>java.sql.*</code>: For interacting with a SQL database (e.g., connection, queries).</li>
        <li><code>java.time.LocalDate</code>: For handling and validating dates.</li>
        <li><code>java.util.Scanner</code>: To get user input from the console.</li>
        <li><code>librery.displayMenu</code>, <code>librery.inputUtilities</code>, <code>librery.sqlFunctions</code>: Custom libraries to handle menu display, input utilities, and database functions, respectively.</li>
    </ul>
    <h2>2. Program Structure</h2>
    <p>The program starts by displaying a <strong>welcome message</strong> using <code>displayMenu.msgWelcome()</code>. A <code>Scanner</code> object is initialized to capture user input, and a <strong>SQL database connection</strong> is established using <code>sqlFunctions.getConnection()</code>.</p>
    <h2>3. Main Menu Loop</h2>
    <p>The program enters a loop (<code>do { ... } while (!isFinish)</code>) that continuously displays a menu and processes user input until the user chooses to exit (by selecting option <strong>0</strong>).</p>
    <p>The menu options allow users to perform different actions, such as viewing clients, properties, and rent information.</p>
    <h2>4. Menu Options</h2>
    <ul>
        <li><strong>Option 1</strong>: Retrieve and display all clients and their properties.</li>
        <li><strong>Option 2</strong>: Prompt for a client name (or part of it) and list the properties rented by that client.</li>
        <li><strong>Option 3</strong>: Prompt for a start and end date, validate the input, and list clients with properties rented within that date range.</li>
        <li><strong>Option 4</strong>: Calculate and display the total monthly rent for each client.</li>
        <li><strong>Option 5</strong>: Prompt for a property name (or part of it) and find the owner of the property.</li>
        <li><strong>Option 6</strong>: Prompt for an owner’s name and count the properties owned by them.</li>
        <li><strong>Option 7</strong>: Prompt for a number of properties and identify clients owning at least that many properties.</li>
        <li><strong>Option 8</strong>: List all clients along with the total rent they pay annually.</li>
        <li><strong>Option 9</strong>: Find and display the client paying the highest monthly rent.</li>
        <li><strong>Option 10</strong>: List all properties where the rent is greater than the average rent.</li>
        <li><strong>Option 0</strong>: Exit the program.</li>
    </ul>
    <h2>5. Helper Libraries</h2>
    <p>The program uses three helper libraries:</p>
    <ul>
        <li><strong><code>displayMenu</code></strong>: Handles displaying messages and menus to the user.</li>
        <li><strong><code>inputUtilities</code></strong>: Handles user input, like asking for text, dates, or numbers.</li>
        <li><strong><code>sqlFunctions</code></strong>: Contains database-related functions, such as retrieving client data, querying rent information, and performing calculations (e.g., listing clients, properties, and calculating rent).</li>
    </ul>
    <h2>6. Input Handling</h2>
    <p>The program uses <code>inputUtilities</code> for structured input handling, asking the user for text, dates, and integers, depending on the chosen option. For dates (e.g., in <strong>Option 3</strong>), the program parses the user input using <code>LocalDate.parse()</code> and validates that the start date is before the end date.</p>
    <h2>7. Database Interaction</h2>
    <p>The <code>sqlFunctions</code> library contains methods that interact with the database, retrieving or updating data depending on the user's selection. These methods are called to perform SQL operations like listing clients, retrieving properties, calculating rents, etc.</p>
    <h2>8. Error Handling</h2>
    <p>The program uses a <strong>try-catch</strong> block to handle any <code>SQLException</code> that may occur when interacting with the database, logging the errors if they occur.</p>
    <h2>9. Program Termination</h2>
    <p>When the user selects <strong>0</strong>, the loop ends, the <strong>SQL connection</strong> is closed (<code>conn.close()</code>), and the <strong>Scanner</strong> object is also closed to clean up resources.</p>
    <h2>Summary</h2>
    <p>The program is a <strong>command-line-based rental management tool</strong> that connects to a SQL database to:</p>
    <ul>
        <li>Retrieve information about clients and their rented properties.</li>
        <li>Calculate rents (monthly and annually) for each client.</li>
        <li>Manage property-owner relationships.</li>
        <li>Validate date ranges and retrieve records within those ranges.</li>
        <li>Perform various other rental-related management functions.</li>
    </ul>
    <p>It provides an interactive menu that allows the user to input data, make selections, and view the results based on database queries. The program handles user input, interacts with a database, and ensures data integrity through input validation and exception handling.</p>
