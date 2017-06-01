package com.deere.isg.demo;

import java.util.function.Function;
//in object oriented programming where an object, instead of performing one of its stated tasks,
//delegates that task to the helper object. There is an inversion of responsibility in which a helper object, known
//as delegate, is given the responsibility to execute a task for the delegator
public class Delegator {
    static class CalculateNAV {
        private Function<String, Double> _priceFinder;

        public CalculateNAV(Function<String, Double> priceFinder) {
            _priceFinder = priceFinder;
        }

        public double compute(String ticker, int stocks) {
            return stocks * _priceFinder.apply(ticker);
        }
    }

    // Java 8 Way
    static class StockFetcher {
        public static double getStockPrice(String ticker) {
            System.out.println("Do real work and get the stock price...");
            return 35.55;
        }
    }

    public static void main(String[] args) {
        CalculateNAV calculateNAV = new CalculateNAV(ticker -> 33.33);
        System.out.println(calculateNAV.compute("ORCL", 100));

        // Java 8 Way
        CalculateNAV calculateNAV2 = new CalculateNAV(StockFetcher::getStockPrice);
        System.out.println(calculateNAV2.compute("ORCL", 100));
    }
}

