import java.util.Scanner;
import java.text.DecimalFormat;

public class TipCalculatorRunner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        // getting the instance variable values
        System.out.println("Welcome to tip calculator!");
        System.out.print("How many people are in your group? ");
        int numPeople = scan.nextInt();
        System.out.print("What's the tip percentage? (0-100): ");
        int tipPercentage = scan.nextInt();

        // creating the object
        TipCalculator price1 = new TipCalculator(numPeople, tipPercentage);

        // start asking user
        double cost = 0;
        while (cost != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            cost = scan.nextDouble();
            price1.addMeal(cost);
        }

        // printing
        System.out.println("--------------------");
        System.out.println("Total Bill Before Tip: " + price1.getTotalBillBeforeTip());
        System.out.println("Tip Percentage: " + tipPercentage);
        System.out.println("Total Tip: " + formatter.format(price1.tipAmount()));
        System.out.println("Total Bill With Tip: " + formatter.format(price1.totalBill()));
        System.out.println("Per Person Cost Before Tip: " + formatter.format(price1.perPersonCostBeforeTip()));
        System.out.println("Tip Per Person: " + formatter.format(price1.perPersonTipAmount()));
        System.out.println("Total Cost Per Person: " + formatter.format(price1.perPersonTotalCost()));
    }
}
