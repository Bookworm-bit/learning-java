import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initiates scanner and currency formatting
        Scanner scanner = new Scanner(System.in);
        NumberFormat currency_formatting = NumberFormat.getCurrencyInstance();

        // Principal
        double principal_amount = 0;
        do {
            System.out.print("Principal ($1K - $1M): ");
            principal_amount = scanner.nextDouble();

            if (principal_amount < 1_000 | principal_amount > 1_000_000) {
                System.out.println("Enter a value between 1,000 and 1,000,000");
            }
        } while (principal_amount < 1_000 | principal_amount > 1_000_000);

        // Interest
        double monthly_interest_rate = 0;
        do {
            System.out.print("Annual Interest Rate: ");
            monthly_interest_rate = scanner.nextDouble() / 1200;

            if (monthly_interest_rate < 0.000833333333 | monthly_interest_rate > 0.025) {
                System.out.println("Enter a value between 1 and 30");
            }
        } while (monthly_interest_rate < (1 / 1200) | monthly_interest_rate > 0.025);

        // Time Period
        double payment_numbers = 0;
        do {
            System.out.print("Period (years): ");
            payment_numbers = scanner.nextDouble() * 12;

            if (payment_numbers < 12 | payment_numbers > 360) {
                System.out.println("Enter a value between 1 and 30");
            }
        } while (payment_numbers < 12 | payment_numbers > 360);

        // (1 + r)^n
        final double EXPARA = Math.pow(1 + monthly_interest_rate, payment_numbers);

        /*
         * Plug values into formula
         * P * ((r * (1 + r)^n) / (1 + r)^n - 1)
         */
        System.out.println(
                currency_formatting.format(principal_amount * ((monthly_interest_rate * EXPARA) / (EXPARA - 1))));

        scanner.close();
    }
}
