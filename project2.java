import java.util.Scanner;

public class project2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();

        // Outer loop for rows
        for (int i = 1; i <= n; i++) {

            // Print spaces for alignment
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            // Print numbers for the current row
            for (int num = 1; num <= i; num++) {
                System.out.print(num + " ");
            }

            // Move to the next line
            System.out.println();
        }
    }
}
