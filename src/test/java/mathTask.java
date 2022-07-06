import java.util.Scanner;

public class mathTask {

    public static double repeatPeriod(int period, int count, int periodLength) {
        double result = 0;
        for (int i = 1; i <= count; i++) {
            result += (double)period / Math.pow(10, periodLength * i);
        }

        return result;
    }

    public static int countDigitsNumber(int number) {
        return number > 0 ? (int)Math.floor(Math.log10(number)) + 1 : 0;
    }

    public static int nod(int a,int b) {
        while (b !=0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }

    public static int[] convertPeriodicFractionToRegular(int[] digits) {
        int integerPart = digits[0];
        int fractionalPeriodicPart = digits[1];

        int digitsCount = countDigitsNumber(fractionalPeriodicPart);
        double doubleNumber = integerPart + repeatPeriod(fractionalPeriodicPart, 2, digitsCount);

        return new int[] { (int) Math.round((Math.pow(10, digitsCount) - 1) * doubleNumber), (int) Math.pow(10, digitsCount) - 1 };
    }

    public static void periodicFractionCalculation(int[] digits) {
        int[] regularFraction = convertPeriodicFractionToRegular(digits);
        int nod = nod(regularFraction[0], regularFraction[1]);
        System.out.println(regularFraction[0] / nod + " " + regularFraction[1] / nod);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int integerPart = input.nextInt();
        int fractionalPeriodicPart = input.nextInt();

        periodicFractionCalculation(new int[] { integerPart, fractionalPeriodicPart});
    }
}
