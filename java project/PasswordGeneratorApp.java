import java.util.Scanner;


// Main application class
public class PasswordGeneratorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordCriteria criteria = new PasswordCriteria();
        PasswordGenerator generator = new PasswordGenerator(criteria);
        PasswordWriter writer = new PasswordWriter("generated_passwords.txt");

        System.out.print("Enter desired password length: ");
        int length = 0;

        // Simple input validation for positive integer length
        while (true) {
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length > 0) {
                    break;
                } else {
                    System.out.print("Please enter a positive integer for password length: ");
                }
            } else {
                System.out.print("Invalid input. Enter a valid integer: ");
                scanner.next();
            }
        }

        String password = generator.generate(length);
        System.out.println("Generated password: " + password);

        // Write generated password to file
        writer.writeToFile(password);

        scanner.close();
    }
}

