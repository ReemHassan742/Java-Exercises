//Divide the number by 2.
//Record the result and the remainder.
//Continue to divide the result by 2.
//Stop until the result is 0.
//The binary answer is the remainder,read it from bottom

import java.util.Scanner;

public class Binary {
    public static void main(String args[]) {

        int decimal_num, quot, i = 1, j;
        int binary_num[] = new int[100];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a Decimal Number: ");
        decimal_num = scanner.nextInt();

        quot = decimal_num;

        while (quot != 0) {
            binary_num[i++] = quot % 2;
            quot = quot / 2;
        }
        System.out.print("Binary number is: ");

        for (j = i - 1; j > 0; j--) {
            System.out.print(binary_num[j]);
        }

    }
}