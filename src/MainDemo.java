import java.util.List;

public class MainDemo {
    public static void main(String[] args) {
        List<Transaction> trans =  GetTran.getTran();
        GetTran.getAllTran(trans);
        GetTran.getTotalOutgoing(trans);
        GetTran.getMonthlyAvegSpend(trans);
        GetTran.getHighestSpendYearly(trans);
        GetTran.getLowestSpendYearly(trans);


    }
}
