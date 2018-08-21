package cn.tedu.store.aop;

import cn.tedu.store.service.StudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 生成动态代理类的辅助类
 */
@Component
public class StudentProxyHandler implements InvocationHandler {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentAop studentAop;

    /**
     * 获取动态代理类的对象
     * @return
     */
    public Object getProxy(){
        // 第一个参数:表示目标类的类加载器的对象
        // 第二个参数:表示目标类的接口对象
        // 第三个参数:表示实现了InvocationHandler接口的类的对象
        return Proxy.newProxyInstance(
                studentService.getClass().getClassLoader(),
                studentService.getClass().getInterfaces(),
                this); // 动态代理类自动创建的
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 模拟前置通知
        studentAop.log();
        // 表示通过"反射"调用studentService的方法
        // 等价于studentService.login(args);
        Object obj = method.invoke(studentService, args);
        return obj;
    }



}
