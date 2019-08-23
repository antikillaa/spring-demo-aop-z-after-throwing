package by.peshkur.aopdemo.aspect;

import by.peshkur.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //add a new advice for @AfterReturning on the findAccounts method

    @AfterThrowing(
            pointcut = "execution(* by.peshkur.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + exception);

    }

    @AfterReturning(
            pointcut = "execution(* by.peshkur.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint joinPoint, List<Account> result) {

        //print which method we are advising on
        String method = joinPoint.getSignature().toString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        //print out the results of the method call
        System.out.println("\n=====>>> result is: " + result);

        //let's post-process the data ... let's modify it :-)

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperName = account.getName().toUpperCase();

            account.setName(upperName);
        }
    }


    @Before("AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        //display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments

        //get args
        Object[] objects = joinPoint.getArgs();

        //loop thru args
        for (Object object : objects){
            System.out.println(object);

            if (object instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) object;
                System.out.println("account name: " + account.getName());
                System.out.println("account name: " + account.getLevel());
            }
        }


    }

}
