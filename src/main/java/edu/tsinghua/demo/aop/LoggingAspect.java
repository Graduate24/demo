package edu.tsinghua.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(Log)")
    public void logPointcut() {
    }

    @Pointcut("execution(public void edu.tsinghua.demo.aop.ShipmentService.shipStuffWithBill())")
    public void logPointcutWithExecution() {
    }

    @Pointcut("execution(public * edu.tsinghua.demo.aop.BillService.*(..))")
    public void logPointCutWithWildcard() {
    }

    @Pointcut("within(edu.tsinghua.demo.aop.OrderService) && execution(public String edu.tsinghua.demo.aop.OrderService.*(..))")
    public void logPointcutWithLogicalOperator() {
    }


    @Before("logPointcut()")
    public void logAllMethodCallsAdvice() {
        System.out.println("In Aspect");
    }

    @Before("logPointcutWithExecution()")
    public void logMethodCallsWithExecutionAdvice() {
        System.out.println("In Aspect from execution");
    }

    @Before("logPointcutWithLogicalOperator()")
    public void logPointcutWithLogicalOperatorAdvice() {
        System.out.println("In Aspect from logical operator");
    }

    @Around("logPointCutWithWildcard()")
    public void logAllMethodCallsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //before point joint
        System.out.println("In Aspect at " + joinPoint.getSignature().getName());
        System.out.println("==");
        Object[] newArgus = new Object[joinPoint.getArgs().length];
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            Object o = joinPoint.getArgs()[i];
            System.out.println("before arg: " + o);
            if (o instanceof String) {
                newArgus[i] = "nwe_" + o;
                System.out.println("change to " + newArgus[i]);
            }
            if (o instanceof Double) {
                newArgus[i] = ((Double) o) + 100;
                System.out.println("change to " + newArgus[i]);
            }
        }
        // execute point joint
        System.out.print("execute point joint: ");
        joinPoint.proceed(newArgus);
        System.out.println("==");
        //after point joint
        System.out.println("after...");


    }
}