package OpenChallenge3;

public class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void deposit(int[] amounts) {
        for (int amount : amounts) {
            deposit(amount);
        }
    }

    public int withdraw(int amount) {
        if (amount > balance) {
            int withdrawnAmount = balance;
            balance = 0;
            return withdrawnAmount;
        } else {
            balance -= amount;
            return amount;
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account a = new Account(100);
        a.deposit(5000);
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
        
        int bulk[] = {100, 500, 200, 700};
        a.deposit(bulk);
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
        
        int money = 1000;
        int wMoney = a.withdraw(money);
        if (wMoney < money)
            System.out.println(wMoney + "원만 인출");
        else
            System.out.println(wMoney + "원 인출");
        
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
    }
}