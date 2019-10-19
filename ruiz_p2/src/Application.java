public class Application {

    public static void main(String[] args) {

        SavingsAccount sav1 = new SavingsAccount();
        SavingsAccount sav2 = new SavingsAccount();

        SavingsAccount.modifyInterestRate(4.0);

        sav1.setSavingsBalance(2000.00);
        sav2.setSavingsBalance(2000.00);

        for(int i = 1; i <= 12; i++){
            System.out.println("Month " + i + "-------------- Interest Rate: " + SavingsAccount.getAnnualInterestRate());
            System.out.printf("Saver 1: Original Balance: %.2f\n", sav1.getSavingsBalance());
            sav1.calculateMonthlyInterest();
            System.out.printf("         New Balance: %.2f\n\n", sav1.getSavingsBalance());
            System.out.printf("Saver 2: Original Balance: %.2f\n", sav2.getSavingsBalance());
            sav2.calculateMonthlyInterest();
            System.out.printf("         New Balance: %.2f\n\n", sav2.getSavingsBalance());
        }

        SavingsAccount.modifyInterestRate(5.0);

        for(int i = 1; i <= 1; i++){
            System.out.println("Month " + i + "-------------- Interest Rate: " + SavingsAccount.getAnnualInterestRate());
            System.out.printf("Saver 1: Original Balance: %.2f\n", sav1.getSavingsBalance());
            sav1.calculateMonthlyInterest();
            System.out.printf("         New Balance: %.2f\n\n", sav1.getSavingsBalance());
            System.out.printf("Saver 2: Original Balance: %.2f\n", sav2.getSavingsBalance());
            sav2.calculateMonthlyInterest();
            System.out.printf("         New Balance: %.2f\n\n", sav2.getSavingsBalance());
        }
    }
}
