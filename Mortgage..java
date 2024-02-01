import java.util.Scanner;

public class Mortgage

{

    public static void main(String args[])

    {

        Scanner scanner = new Scanner(System.in);
        double monthly_payment, Principal, rate, number_of_payments, numerator, denominator;

        System.out.print("Enter the Principal :");
        Principal = scanner.nextDouble();

        System.out.print("Enter the Rate :");
        rate = scanner.nextDouble();
        rate = (rate / 100) / 12;

        System.out.print("Enter the Number of payments :");
        number_of_payments = scanner.nextDouble();
        number_of_payments = number_of_payments * 12;

        numerator = rate * (Math.pow((1 + rate), number_of_payments));
        denominator = Math.pow((1 + rate), number_of_payments) - 1;

        monthly_payment = Principal * numerator / denominator;
        System.out.println("The Monthly payment is :" + Math.ceil(monthly_payment));

    }

}
