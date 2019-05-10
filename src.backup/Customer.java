

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

import java.text.DecimalFormat;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }
    
    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }
    
    public int getNumberOfAccounts() {
        return accounts.size();
    }
    //计算客户各账户的总利�?
    public double totalInterestEarned() {
        double total = 0;
        //自己�?
        int account_num=getNumberOfAccounts();
        for(int i=0;i<account_num;i++) {
        	total=total+accounts.get(i).interestEarned();
        }
        //
        return total;
    }
    
    //获取�?有账户详�?
    public String getStatement() {
        String statement = "";
        //自己�?
        DecimalFormat df=new DecimalFormat(",###.00");
        double totalrest=0; //该用户所有账户余额的总和
        int account_num=getNumberOfAccounts();
        statement=statement+"Statement for "+name+"\n"+"\n";
        for(int i=0;i<account_num;i++) {
        	Account acc=accounts.get(i);
        	if(acc.getAccountType()==0)
        		statement=statement+"Checking Account"+"\n";
        	else if(acc.getAccountType()==1)
        		statement=statement+"Savings Account"+"\n";
        	else 
        		statement=statement+"Maxi Savings Account"+"\n";
        	for(int j=0;j<acc.transactions.size();j++) {
        		if(acc.transactions.get(j).amount>=0) {
        			statement=statement+"  deposit $"+df.format(acc.transactions.get(j).amount)+"\n";
        		}
        		else {
        			statement=statement+"  withdrawal $"+df.format(-acc.transactions.get(j).amount)+"\n";
        		}
        	}
        	statement=statement+"Total $"+df.format(acc.sumTransactions())+"\n"+"\n";
        	totalrest=totalrest+acc.sumTransactions();
        }
        statement=statement+"Total In All Accounts $"+df.format(totalrest);
        //
        return statement;
    }
        
    //格式化金额输出，无需修改,可直接引�?
    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}
