import java.util.Map;

public class FinancialForecast {

    // Step 2: Basic recursive method to calculate future value
    // using a single, constant growth rate (like compound interest)
    // FV = PV * (1 + rate) ^ years, calculated one year at a time
    public static double simpleRecursiveFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return simpleRecursiveFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Step 3: Recursive forecast based on a series of past growth rates.
    // If the forecast horizon is longer than the available history,
    // the past growth rates are reused in a cycle.
    // NOTE: this is the naive version - it recomputes the value for
    // every earlier year each time it is called.
    public static double forecastValueAtYear(double presentValue, double[] pastGrowthRates, int year) {
        if (year == 0) {
            return presentValue;
        }
        double previousValue = forecastValueAtYear(presentValue, pastGrowthRates, year - 1);
        double rate = pastGrowthRates[(year - 1) % pastGrowthRates.length];
        return previousValue * (1 + rate);
    }

    // Step 4: Optimized version of the same forecast using memoization.
    // Each year's value is calculated only once and then reused.
    public static double forecastValueAtYearMemo(double presentValue, double[] pastGrowthRates,
                                                   int year, Map<Integer, Double> memo) {
        if (year == 0) {
            return presentValue;
        }
        if (memo.containsKey(year)) {
            return memo.get(year);
        }
        double previousValue = forecastValueAtYearMemo(presentValue, pastGrowthRates, year - 1, memo);
        double rate = pastGrowthRates[(year - 1) % pastGrowthRates.length];
        double value = previousValue * (1 + rate);
        memo.put(year, value);
        return value;
    }
}