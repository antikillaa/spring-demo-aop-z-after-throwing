package by.peshkur.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* by.peshkur.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    //create point cut for getter methods
    @Pointcut("execution(* by.peshkur.aopdemo.dao.*.get*(..))")
    public void getter() {}

    //create point cut for setter methods
    @Pointcut("execution(* by.peshkur.aopdemo.dao.*.set*(..))")
    public void setter() {}


    //create point: include package .. exclude getters/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
