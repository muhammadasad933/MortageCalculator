import java.text.NumberFormat;

public class MortageReport {
    private final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private  MortageCalculator calculator;
    public MortageReport(MortageCalculator calculator) {
        this.calculator = calculator;
    }
    public double printMortage() {
        double mortage= calculator.calculateMortage();
        String mortageFormated = currency.format(mortage);
        System.out.println("MORTAGE");
        System.out.println("--------------");
        System.out.println("MONTHLY PAYMENT: " + mortageFormated);
        System.out.println("--------------");
        return mortage;
    }
    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(double balance: calculator.getRemainingBalance()){
            System.out.println(currency.format(balance));
        }
    }
}
