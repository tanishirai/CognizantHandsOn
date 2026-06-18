import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // ---- Step 2: Simple recursive future value (single constant growth rate) ----
        double presentValue = 100000; // e.g. current revenue or investment amount
        double growthRate = 0.08;     // 8% growth per year
        int years = 5;

        double futureValue = FinancialForecast.simpleRecursiveFutureValue(presentValue, growthRate, years);

        System.out.println("---- Step 2: Simple Recursive Future Value ----");
        System.out.printf("Present Value: %.2f%n", presentValue);
        System.out.printf("Growth Rate: %.2f%%%n", growthRate * 100);
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);

        // ---- Step 3: Forecast using a series of past growth rates ----
        // e.g. the actual growth rates observed over the last 4 years
        double[] pastGrowthRates = {0.05, 0.07, 0.03, 0.06};
        int forecastYears = 10;

        System.out.println("\n---- Step 3: Forecast Table using Past Growth Rates ----");
        for (int year = 1; year <= forecastYears; year++) {
            double value = FinancialForecast.forecastValueAtYear(presentValue, pastGrowthRates, year);
            System.out.printf("Year %2d -> %.2f%n", year, value);
        }

        // ---- Step 4: Naive recursion vs memoized recursion ----
        int n = 2000; // larger horizon so the timing difference is visible

        long startNaive = System.nanoTime();
        for (int year = 1; year <= n; year++) {
            FinancialForecast.forecastValueAtYear(presentValue, pastGrowthRates, year);
        }
        long endNaive = System.nanoTime();

        long startMemo = System.nanoTime();
        Map<Integer, Double> memo = new HashMap<>();
        for (int year = 1; year <= n; year++) {
            FinancialForecast.forecastValueAtYearMemo(presentValue, pastGrowthRates, year, memo);
        }
        long endMemo = System.nanoTime();

        System.out.println("\n---- Step 4: Naive vs Memoized (building a " + n + "-year table) ----");
        System.out.println("Naive recursion time:    " + (endNaive - startNaive) + " ns");
        System.out.println("Memoized recursion time: " + (endMemo - startMemo) + " ns");
    }
}