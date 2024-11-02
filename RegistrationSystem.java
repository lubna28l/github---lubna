import java.util.ArrayList;
import java.util.Scanner;
// Class representing a User
class User {
   private String username;
   private String password;
   // Constructor for User
   public User(String username, String password) {
       this.username = username;
       this.password = password;
   }
   // Getters
   public String getUsername() {
       return username;
   }
   public String getPassword() {
       return password;
   }
}
// Class representing the Registration System
public class RegistrationSystem {
   private static final ArrayList<User> users = new ArrayList<>(); // List to store registered users
   // Method to create a new account
   public static void createAccount(String username, String password) {
       // Check if the username already exists
       for (User user : users) {
           if (user.getUsername().equals(username)) {
               System.out.println("Username already exists! Please choose a different one.");
               return;
           }
       }
       // Create a new user and add to the list
       User newUser = new User(username, password);
       users.add(newUser);
       System.out.println("Account created successfully for " + username + "!");
   }
   // Method to login
   public static void login(String username, String password) {
       for (User user : users) {
           if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
               System.out.println("Login successful! Welcome " + username + "!");
               return;
           }
       }
       System.out.println("Invalid username or password! Please try again.");
   }
   // Method to handle forgotten password
   public static void forgetPassword(String username) {
       for (User user : users) {
           if (user.getUsername().equals(username)) {
               System.out.println("Your password is: " + user.getPassword());
               return;
           }
       }
       System.out.println("Username not found! Please check and try again.");
   }
   // Main method: program entry point
   public static void main(String[] args) {
       Scanner kb = new Scanner(System.in);
       int option;
       // Main menu loop for the registration system
       while (true) {
           System.out.println("Select an option: ");
           System.out.println("1: Create Account");
           System.out.println("2: Login");
           System.out.println("3: Forget Password");
           System.out.println("4: Exit");
           option = kb.nextInt();
           kb.nextLine(); // Consume newline
           switch (option) {
               case 1 -> {
                   // Gather account details from the user
                   System.out.println("Enter username: ");
                   String username = kb.nextLine();
                   System.out.println("Enter password: ");
                   String password = kb.nextLine();
                   createAccount(username, password);
               }
               case 2 -> {
                   // Gather login details from the user
                   System.out.println("Enter username: ");
                   String username = kb.nextLine();
                   System.out.println("Enter password: ");
                   String password = kb.nextLine();
                   login(username, password);
               }
               case 3 -> {
                   // Gather username for forgotten password
                   System.out.println("Enter your username: ");
                   String username = kb.nextLine();
                   forgetPassword(username);
               }
               case 4 -> {
                   System.out.println("Exiting the application. Goodbye!");
                   kb.close();
                   System.exit(0);
               }
               default -> System.out.println("Invalid option! Please try again.");
           }
       }
   }
}