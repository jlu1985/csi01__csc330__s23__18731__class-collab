package csc330.ch9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class GasPrice {

    public static void main(String[] args) throws Exception {

        Map<Integer, StatsByYear> byYearMap = new HashMap<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     GasPrice.class.getClassLoader().getResourceAsStream("csc330/ch9/gas.txt")))) {

            List<DateAndPrice> lowest = bufferedReader.lines()
                    .map(DateAndPrice::parse)
                    .map(dateAndPrice -> {
                        byYearMap.compute(dateAndPrice.year(),
                                (yearKey, existingStatsByYear) ->
                                        Optional.ofNullable(existingStatsByYear)
                                                .orElseGet(() -> new StatsByYear(yearKey))
                                                .add(dateAndPrice));
                        return dateAndPrice;
                    }).sorted(Comparator.comparing(DateAndPrice::price)
                            .thenComparing(DateAndPrice::year)
                            .thenComparing(DateAndPrice::month)
                            .thenComparing(DateAndPrice::day))
                    .toList();

            byYearMap.values().stream().forEach(System.out::println);

            for (int i = 0, j = lowest.size() - 1; i < lowest.size(); i++, j--) {
                System.out.printf("loToHi=%s  hiToLo=%s%n", lowest.get(i).rawString(), lowest.get(j).rawString());
            }

        }
    }

    record DateAndPrice(String rawString, int year, int month, int day, double price) {
        public static DateAndPrice parse(String raw) {
            String[] split = raw.split(":");
            var price = Double.parseDouble(split[1]);
            String[] mmddyyyy = split[0].split("-");
            var year = Integer.parseInt(mmddyyyy[2]);
            var month = Integer.parseInt(mmddyyyy[0]);
            var day = Integer.parseInt(mmddyyyy[1]);
            return new DateAndPrice(raw, year, month, day, price);
        }

    }

    static class StatsByYear {
        private final Map<Integer, Double> avgByMonth = new HashMap<>();
        private final Integer year;
        private double highest = Double.MIN_VALUE;
        private double lowest = Double.MAX_VALUE;

        public StatsByYear(int year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return "StatsByYear{" +
                    "year=" + year +
                    ", avgByMonth=" + avgByMonth +
                    ", highest=" + highest +
                    ", lowest=" + lowest +
                    ", yearAvg=" + getYearAvg() +
                    '}';
        }

        public StatsByYear add(DateAndPrice dateAndPrice) {
            if (dateAndPrice.year() != this.year) {
                return this;
            }
            avgByMonth.merge(dateAndPrice.month, dateAndPrice.price,
                    (a, b) -> BigDecimal.valueOf(a + b)
                            .divide(BigDecimal.valueOf(2))
                            .setScale(3, RoundingMode.HALF_UP)
                            .doubleValue());

            if (dateAndPrice.price > highest) {
                highest = dateAndPrice.price;
            }

            if (dateAndPrice.price < lowest) {
                lowest = dateAndPrice.price;
            }
            return this;

        }

        public double getYearAvg() {
            return BigDecimal.valueOf(avgByMonth.values().stream()
                            .collect(Collectors.summingDouble(Double::doubleValue)) / avgByMonth.size())
                    .setScale(3, RoundingMode.HALF_UP).doubleValue();
        }


    }
}

