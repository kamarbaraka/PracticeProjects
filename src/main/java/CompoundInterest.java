import java.util.*;

/**
 * a simple java program to compute compound interest over time in years
 * @author kamar baraka
 * @version 1.0
 * @since 20/05/2023 20:00
 * */
public class CompoundInterest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        var prompt = System.out;
        prompt.println("what's your current balance; ");
        double balance = input.nextDouble();
        prompt.println("what's the starting rate;");
        double startingRate = input.nextDouble();
        prompt.println("for how long (in years)");
        int years = input.nextInt();
        Computation comp = new Computation(balance, startingRate, years);
        Tabulation table = new Tabulation(comp);
    }
}

class Computation{
    final double START_RATE, theBalance;
    final int N_RATES, N_YEARS;
    double[] interestRates;
    double[][] table;
    public Computation(double balance, double startingRate, int years){
        theBalance = balance;
        START_RATE = startingRate;
        N_RATES = 10;
        N_YEARS = years;

        compute();
    }
    private void compute(){
//        create an array to store the interest rates
        interestRates = new double[N_RATES];
        for (int i = 0; i < interestRates.length; i++)
            interestRates[i] = (START_RATE + i)/100.0;

//        create a 2D array to hold our compound data
        table = new double[N_YEARS][N_RATES];

//        set the initial balances to 10,000 in the first row
        Arrays.fill(table[0], theBalance);

//        compute the interest for future years
        for (int i = 1; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
//                get last year's balance from previous row
                var lastYearBalance = table[i - 1][j];
//                compute the interest
                var interestGained = lastYearBalance * interestRates[j];
//                compute this year's balance
                table[i][j] = lastYearBalance + interestGained;
            }
        }
    }
}

class Tabulation{
    public Tabulation(Computation comp){
//        print row of interest rates
        for (double interest : comp.interestRates)
            System.out.printf("%9.1f%%", 100 * interest);
        System.out.println();

//        print the balance table
        for (double[] row : comp.table){
            for (double column : row)
                System.out.printf("%10.2f", column);
            System.out.println();
        }
    }
}