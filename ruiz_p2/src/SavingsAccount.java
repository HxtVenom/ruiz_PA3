public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(){
        savingsBalance = 0;
    }

    public static void modifyAnnualInterestRate(double interestRate){
        annualInterestRate = interestRate / 100.0;
    }

    public static double getAnnualInterestRate(){
        return annualInterestRate * 100;
    }


    public void setSavingsBalance(double balance){
        savingsBalance = balance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void calculateMonthlyInterest(){
        savingsBalance = ((savingsBalance * annualInterestRate) / 12.0) + savingsBalance;
    }

}
