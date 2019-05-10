

import java.util.ArrayList;
import java.util.List;

import org.junit.rules.ExpectedException;

public class Account {//

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;
    
    private double rest;
    
    private final int accountType;
    public List<Transaction> transactions;

    public Account(int accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
        rest=0;
    }
    //存款,�?对存款数<=0的情况进行异常处�?,异常详情参�?�测试用�?
    public void deposit(double amount) {
    	//自己�?
    	rest=sumTransactions();
        if(amount<=0) {
        	throw new IllegalArgumentException("amount must be greater than zero");
        }
        else {
        	rest=rest+amount;
        }
        transactions.add(new Transaction(amount));
        //
    }
    
    //取款,�?对取款数和账户余�?<=0的情况分别进行异常处�?,异常详情参�?�测试用�?
    public void withdraw(double amount) {
    	//自己�?
    	rest=sumTransactions();
    	if(amount<=0) {
    		throw new IllegalArgumentException("amount must be greater than zero");
        }
    	else if(rest<=0||rest<amount) {
    		throw new IllegalArgumentException("sumTransactions must be greater than zero");
    	}
    	else {
    		rest=rest-amount;
    	}
    	
    	
    	transactions.add(new Transaction(-amount));
    }
    
    //根据不同的账号类型，确定不同利率进行利息计算
    public double interestEarned() {
        double accrual=0;//定义�?始利息为0
        //自己�?
        switch(accountType) {
        case CHECKING:
        	accrual=rest*0.001;
        	break;
        case SAVINGS:
        	if(rest<=1000) {
        		accrual=rest*0.001;
        		break;
        	}
        	else {
        		accrual=1000*0.001+(rest-1000)*0.002;
        		break;
        	}
        case MAXI_SAVINGS:
        	if(rest<=1000) {
        		accrual=rest*0.002;
        		break;
        	}
        	else if(1000<rest&&rest<=2000) {
        		accrual=1000*0.02+(rest-1000)*0.05;
        		break;
        	}
        	else {
        		accrual=1000*0.02+1000*0.05+(rest-2000)*0.1;
        		break;
        	}
        }
        	
        return accrual;
    }
    
  //返回账号余额
    public double sumTransactions() {
    	 //double amount = 0.0;
         //return amount;
    	return rest;
    }
    
    public int getAccountType() {
        return accountType;
    }

}
