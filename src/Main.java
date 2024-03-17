public class Main {
    public static void main(String[] args) {
         int principle=(int) Console.readValue("Principle: ", 1000, 1000000);
         float interestYearly=(float) Console.readValue("Yearly Interest Rate: ", 1, 30);
         byte period= (byte) Console.readValue("Period: ", 1, 30);
         var calculator= new MortageCalculator(principle,interestYearly,period);
         var report=new MortageReport(calculator);
         report.printMortage();
         System.out.println("BALANCE");
         report.printPaymentSchedule();
    }
}
