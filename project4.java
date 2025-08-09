import java.util.Scanner;

public class project4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== TEMPERATURE CONVERTER ===");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    float celsius = sc.nextFloat();
                    float fahrenheit = (celsius * 9 / 5) + 32; // formula to convert into fahrenhiet
                    System.out.println(celsius + "°C = " + fahrenheit + "°F");
                    break;

                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    fahrenheit = sc.nextFloat();
                    celsius = (fahrenheit - 32) * 5 / 9; // formula to convert into celsius
                    System.out.println(fahrenheit + "°F = " + celsius + "°C");
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
