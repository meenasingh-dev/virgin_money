import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;


public class GetTran {
    public static List<Transaction> getTran() {
        List<Transaction> transaction = new ArrayList<>();
        transaction.add(new Transaction(LocalDate.of(2020, Month.NOVEMBER, 01),
                "Morrisons", "card", 10.40,
                "Groceries"));
        transaction.add(new Transaction(LocalDate.of(2020, Month.NOVEMBER, 10),
                "Morrisons", "card", 10,
                "Groceries"));
        transaction.add(new Transaction(LocalDate.of(2021, Month.NOVEMBER, 01),
                "Morrisons", "card", 10.67,
                "Groceries"));
        transaction.add(new Transaction(LocalDate.of(2020, Month.OCTOBER, 28),
                "CYBG", "direct debit", 600,
                "MyMonthlyDD"));
        transaction.add(new Transaction(LocalDate.of(2020, Month.OCTOBER, 28),
                "PureGym", "direct debit", 40,
                "MyMonthlyDD"));
        transaction.add(new Transaction(LocalDate.of(2021, Month.OCTOBER, 20),
                "PureGym", "direct debit", 40.44,
                "MyMonthlyDD"));
        transaction.add(new Transaction(LocalDate.of(2020, Month.OCTOBER, 01),
                "M&S", "card", 5.99,
                "Groceries"));
        transaction.add(new Transaction(LocalDate.of(2020, Month.SEPTEMBER, 30),
                "McMillan", "internet", 10,
                "Retail"));
        transaction.add(new Transaction(LocalDate.of(2020, Month.OCTOBER, 30),
                "McMillan", "internet", 100.12,
                "Retail"));
        return transaction;
    }
    //All transactions groupby category--latest first
    public static void getAllTran(List<Transaction> trans) {
        Map<String, List<Transaction>> collect = trans.stream()
                .sorted(Comparator.comparing(Transaction::getTranDate))
                .collect(Collectors.groupingBy(Transaction::getCategory));
         System.out.println(collect);
    }
    //Total outgoing per category
    public static void getTotalOutgoing(List<Transaction> trans) {
        Map<String, Double> collect = trans.stream().collect(
                Collectors.groupingBy(Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)));
       System.out.println(collect);

    }
        //Monthly average spend in a given category
    public static void getMonthlyAvegSpend(List<Transaction> trans){
        Map<String, Map<Integer, Map<Month, Double>>> collect = trans.stream().collect(
                Collectors.groupingBy(Transaction::getCategory,
                        Collectors.groupingBy(t -> t.getTranDate().getYear(),
                                Collectors.groupingBy(t -> t.getTranDate().getMonth(),
                                        Collectors.averagingDouble(Transaction::getAmount)))));
        System.out.println(collect);

    }
        //Highest spend in a given category, for a given year
    public static void getHighestSpendYearly(List<Transaction> trans) {
        Map<Integer, Map<String, Double>> collect = trans.stream().collect(
                Collectors.groupingBy(t -> t.getTranDate().getYear(),
                        Collectors.groupingBy(Transaction::getCategory,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Transaction::getAmount)),
                                        t -> t.map(Transaction::getAmount).get()))));

        System.out.println(collect );

    }
    //Lowest spend in a given category, for a given year
    public static void getLowestSpendYearly(List<Transaction> trans){
        Map<Integer, Map<String, Double>> collect = trans.stream().collect(
                Collectors.groupingBy(t -> t.getTranDate().getYear(),
                        Collectors.groupingBy(Transaction::getCategory,
                                Collectors.collectingAndThen(
                                        Collectors.minBy(Comparator.comparing(Transaction::getAmount)),
                                        t -> t.map(Transaction::getAmount).get()))));

        System.out.println(collect);
    }
}
