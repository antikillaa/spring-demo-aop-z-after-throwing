package by.peshkur.aopdemo;

import by.peshkur.aopdemo.dao.AccountDAO;
import by.peshkur.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring congig class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean from spring container

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);


        // call the business method
        Account account = new Account();
        account.setName("Mandoo");
        account.setLevel("Platinum");

        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        //call the accauntdao getter/setter methods

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();


        //call membership method
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();

        // close the context
        context.close();
    }
}
