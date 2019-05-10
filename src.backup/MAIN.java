
public class MAIN {

	public static void main(String[] args) {
		// TODO 自动生成的方法存�?
		Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);
        Account maxisavingsAccount = new Account(Account.MAXI_SAVINGS);

        Customer henry = new Customer("Henry");
        henry.openAccount(checkingAccount);
        henry.openAccount(savingsAccount);
        henry.openAccount(maxisavingsAccount);
        checkingAccount.deposit(100.0);
        checkingAccount.withdraw(50.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);
        maxisavingsAccount.deposit(500);
        String s="Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "  withdrawal $50.00\n" +
                "Total $50.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Maxi Savings Account\n" +
                "  deposit $500.00\n" +
                "Total $500.00\n" +
                "\n" +
                "Total In All Accounts $4,350.00";
        String res= henry.getStatement();
        System.out.println(s);
        System.out.println();
        System.out.println(res);

	}

}
