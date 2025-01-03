import java.util.Scanner;

public class FinalBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Electricity Billing System");
        System.out.println("---------------------------");

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        int accountNumber = 0;
        boolean isValidAccountNumber = false;
        while (!isValidAccountNumber) {
            System.out.print("Enter your Consumer Number: ");
            accountNumber = scanner.nextInt();
            if (String.valueOf(accountNumber).length() == 8) {
                isValidAccountNumber = true;
            } else {
                System.out.println("Invalid account number. Please enter a 8-digit number.");
            }
        }

        System.out.print("Enter the previous meter reading: ");
        double previousReading = scanner.nextDouble();

        System.out.print("Enter the current meter reading: ");
        double currentReading = scanner.nextDouble();

        double unitsConsumed = currentReading - previousReading;
        double billAmount = calculateBill(unitsConsumed);

        System.out.println("\nBill Details:");
        System.out.println("-------------");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Consumer Number: " + accountNumber);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Bill Amount: " + billAmount);

        System.out.print("Do you want to make a payment? (yes/no): ");
        String paymentResponse = scanner.next();

        if (paymentResponse.equalsIgnoreCase("yes")) {
            makePayment(billAmount);
        } else {
            System.out.println("Thank you for using our electricity billing system.");
        }
    }

    public static double calculateBill(double unitsConsumed) {
        double billAmount = 0.0;

        if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 1.20;
        } else if (unitsConsumed <= 200) {
            billAmount = 100 * 1.20 + (unitsConsumed - 100) * 1.50;
        } else {
            billAmount = 100 * 1.20 + 100 * 1.50 + (unitsConsumed - 200) * 2.00;
        }

        return billAmount;
    }

    public static void makePayment(double billAmount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the payment amount: ");
        double paymentAmount = scanner.nextDouble();

        if (paymentAmount >= billAmount) {
            System.out.println("Payment successful. Thank you!");
        } else {
            System.out.println("Insufficient payment amount. Please try again.");
        }
    }
}