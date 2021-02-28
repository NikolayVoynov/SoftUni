public class BankAccount {

    private int id;
    private double balance;
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;

    BankAccount() {
        this.id = bankAccountCount++;
    }

    public int getId() {
        return this.id;
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getInterestRate(int years) {
        return BankAccount.interestRate * this.balance * years;
    }
}
