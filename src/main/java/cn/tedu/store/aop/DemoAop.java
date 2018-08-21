package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Component表示实例化对象
 * Aspect表示当前类是切面类
 * 五种通知
 */
@Component
@Aspect
public class DemoAop {

    /**
     * 前置通知
     * Before表示在业务层方法之前执行
     * bean()表示规范的格式
     * bean(userService)表示在userService业务层的方法之前执行
     */
    @Before("bean(userService)")
    public void test1(){
        System.out.println("之前....");
    }

    /**
     * 后置通知1
     * After也称最终通知 不管有没有异常都会执行的代码
     */
    @After("bean(userService)")
    public void test2(){
        System.out.println("之后1...");
    }

    /**
     * 后置通知2 发生异常不执行
     * AfterReturning不发生异常的时候执行的代码
     */
    @AfterReturning("bean(userService)")
    public void test3(){
        System.out.println("之后2...");
    }

    /**
     * 异常通知，发生异常执行
     * AfterThrowing发生异常的时候执行的代码
     */
    @AfterThrowing("bean(userService)")
    public void test4(){
        System.out.println("发生异常...");
    }

    /**
     * 环绕通知
     *     1.必须要有返回值
     *     2.必须有参数 ProceedingJoinPoint jp
     *     3.参数对象调用方法jp.proceed();
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around("bean(userService)")
    public Object test5(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("环绕通知前....");
        // 表示调用业务方法
        Object obj = jp.proceed(); // 相当于调用login() 上下都环绕jp.proceed()
        System.out.println("环绕通知后....");
        // 返回业务逻辑方法的返回值
        return obj;
    }

    /**
     * 测试业务层的性能
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around("bean(userService)")
    public Object test(ProceedingJoinPoint jp) throws Throwable{
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        System.out.println(end - start); // 毫秒数
        return obj;
    }


}
