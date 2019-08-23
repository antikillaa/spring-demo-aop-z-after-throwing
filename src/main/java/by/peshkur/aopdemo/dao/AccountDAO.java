package by.peshkur.aopdemo.dao;

import by.peshkur.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void  addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    //add a new method: findAccounts

    public List<Account> findAccounts(boolean tripWire) {
        // for academic purpose .. simulate an exception

        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }
        List<Account> accountList = new ArrayList<Account>();

        //create sample accounts
        Account account1 = new Account("John", "Silver", false);
        Account account2 = new Account("Mahbu", "Platinum", false);
        Account account3 = new Account("Luca", "Gold", true);

        //add them to our account list

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        return accountList;
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
