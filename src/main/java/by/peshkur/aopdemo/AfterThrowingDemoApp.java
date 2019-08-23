package by.peshkur.aopdemo;

import by.peshkur.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {
        // read spring congig class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accountList = null;

        //call method to find the accounts
        try {
            boolean tripWire = true;
           accountList = accountDAO.findAccounts(tripWire);

        } catch (Exception e) {
            System.out.println("\n\n Main Program ... caught exception");
        }

        //display the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");
        System.out.println(accountList);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
