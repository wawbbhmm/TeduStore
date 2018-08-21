package cn.tedu.store.aop;

import cn.tedu.store.service.IStudentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StudentProxy implements IStudentService {

    // 在代理类中,既有目标类的对象
    @Resource
    private IStudentService studentService;

    // 还要有切面类的对象
    @Resource
    private StudentAop studentAop;

    @Override
    public void addStudent() {
        //前置通知
        studentAop.log();
        studentService.addStudent();
    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void getById() {

    }

    @Override
    public void getAll() {

    }


}
