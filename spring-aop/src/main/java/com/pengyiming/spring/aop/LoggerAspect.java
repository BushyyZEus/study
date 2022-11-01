package com.pengyiming.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/*
* 1. 切面中,需要通过指定的注解将方法标识为通知方法
* @Before  前置通知,value为切入点表达式,必传,在目标方法执行之前执行
* @After   后置通知,在目标对象方法的finally字句中执行
* @AfterReturning: 返回通知, 在目标对象方法返回值之后执行
* @AfterThrowing: 异常通知, 在目标对象catch字句中执行
*
*
* 5. 切面的优先级
* @Order(1) //设置优先级,设置value属性,数字越小,优先级最高
*
 * */
@Component   //自动装配注解
@Aspect  //切面注解,将当前组件注册为切面

public class LoggerAspect {

    // 声明一个公共的切入点表达式
    // 4. 重用切入点表达式
    // @Pointcut 声明一个公共的切入点表达式
    @Pointcut("execution(* com.pengyiming.spring.aop.Impl.CalculatorImpl.* (..))")
    public void pointCut(){}


    //    切入点写死
//    2.切入点表达式

//    @Before("execution(public int com.pengyiming.spring.aop.Impl.CalculatorImpl.add(int,int))")
//    切入点表达式: 设置在标识通知的注解的value属性中
//    第一个 * 表示任意的访问修饰符和返回值类型
//    第二个 * 表示类中任意的方法
//    .. 表示任意的参数列表,任意个数的任意参数
//    类的地方也可以使用*, 表示包下所有的类
    @Before("pointCut()")
    public void beforeAdviceMethod() {
        System.out.println("LoggerAspect, 前置通知");
    }

    /*
     *   3. 获取连接点的信息
     *       在通知方法的参数位置,设置JoinPoint类型的参数,就可以获取连接点所对应的方法的信息
     *
     *
     * */


    @Before("execution(* com.pengyiming.spring.aop.Impl.CalculatorImpl.*(..))")
    public void beforeAdviceMethod2(JoinPoint joinPoint) {
//        joinpoint 连接点
//        getSignature 获取连接点所对应方法的签名信息,
        Signature signature = joinPoint.getSignature();
//        getArgs 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
//        Object 输出的事内存地址 要用Arrays.toString
//        signature.getName() 获取对应方法名
        System.out.println("LoggerAspect, 方法:" + signature.getName() + ", 参数:" + Arrays.toString(args));
    }
//  使用公共切入点表达式
//    @After 后置通知  finally中执行  异常也会执行
//
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
//        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, 后置通知");
    }

    //returning 接收目标对象方法的返回值的一个参数的参数名
    // 要想在返回通知中,若要获取目标对象方法的返回值, 只需要用returning属性,
    // 就可以将通知方法的某个参数,指定为接受目标对象方法的返回值的参数
    // 注解的参数和方法的参数要一致
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){

        System.out.println("LoggerAspect, 返回通知");
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect, 方法:" + signature.getName() + ", 参数:" + Arrays.toString(args)+", 结果"+result);
    }
    // throwing 属性, 用法同returning, 返回异常名
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex){
        System.out.println("LoggerAspect, 异常通知");
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect, 方法:" + signature.getName() + ", 参数:" + Arrays.toString(args)+", 异常:"+ ex);
    }

    @Around("pointCut()")
    public  Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        //表示目标对象的方法执行
        //用try catch
        //环绕通知一定要将目标方法的返回值返回
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        } finally{
            System.out.println("环绕通知-->后置通知");
        }

        return result;
    }
}