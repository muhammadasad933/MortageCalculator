public class MortageCalculator {
    private final static byte percent = 100;
    private final static byte monthInyear = 12;
    private int principle;
    private float annualInterest;
    private byte years;
    public MortageCalculator(int principle, float annualInterest, byte years) {
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.years = years;
    }
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        double balance = principle
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }
    public double calculateMortage() {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        double result = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return result;
    }
    public double[] getRemainingBalance() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }
    private float getMonthlyInterest() {
        return annualInterest / percent / monthInyear;
    }
    private int getNumberOfPayments() {
        return years * monthInyear;
    }
}