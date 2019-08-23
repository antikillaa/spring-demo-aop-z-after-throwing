package by.peshkur.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean  addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN MEMBERSHIP ACCOUNT");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now...");

    }
}
