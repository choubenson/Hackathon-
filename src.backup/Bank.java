

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    //返回固定格式的客户列�?,格式参�?�测试用�?
    public String customerSummary() {
        String summary = "";
        //自己�?
        summary="Customer Summary"+"\n";
        for(int i=0;i<customers.size();i++) {
        	Customer cus=customers.get(i);
        	summary=summary+" - "+cus.getName()+" ("+cus.getNumberOfAccounts();
        	if(cus.getNumberOfAccounts()==1) {
        		summary=summary+" account)";
        	}
        	else {
        		summary=summary+" accounts)";
        	}
        	if(i!=customers.size()-1) {
        		summary=summary+"\n";
        	}
        }
        
        //
        return summary;
    }
    
    //返回支付�?有客户的利息总和
    public double totalInterestPaid() {
        double total = 0;
        //自己�?
        for(int i=0;i<customers.size();i++) {
        	total=total+customers.get(i).totalInterestEarned();
        }
        //
        return total;
    }

}
