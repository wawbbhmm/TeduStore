package test;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestUser {

    @Test
    public void testInsert() {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper um = ac.getBean("userMapper", UserMapper.class);
        User user = new User();
        // 模拟前台传数据
        user.setUsername("admin");
        user.setPassword("123456");
        user.setEmail("admin@tedu.cn");
        user.setPhone("13800138000");
        um.insertUser(user);
        ac.close();
    }

    @Test
    public void testSelectByUsername(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper um = ac.getBean("userMapper", UserMapper.class);
        User user = um.selectUserByUsername("admin");
        System.out.println(user.toString());
        ac.close();
    }

    @Test
    public void testRegister(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IUserService us = ac.getBean("userService", IUserService.class);
        User user = new User();
        user.setUsername("Jack");
        user.setPassword("888888");
        user.setEmail("admin@tedu.cn");
        user.setPhone("13800138000");
        us.register(user);
    }

    @Test
    public void testSelectByEmail(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        UserMapper um = ac.getBean("userMapper", UserMapper.class);
        System.out.println(um.selectByEmail("admin@tedu.cn"));
        ac.close();
    }

    @Test
    public void  testCheckEmail(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IUserService us = ac.getBean("userService", IUserService.class);
        System.out.println(us.checkEmail("admin@tedu.cn"));
        ac.close();
    }

    @Test
    public void  testSelectByPhone(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        UserMapper um = ac.getBean("userMapper", UserMapper.class);
        System.out.println(um.selectByPhone("13800138000"));
        ac.close();
    }

    @Test
    public void  testCheckPhone(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IUserService us = ac.getBean("userService", IUserService.class);
        System.out.println(us.checkPhone("13800138000"));
        ac.close();
    }

    @Test
    public void testCheckUsername(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IUserService us = ac.getBean("userService", IUserService.class);
        System.out.println(us.checkUsername("admin"));
        ac.close();
    }

    @Test
    public void testLogin(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IUserService us = ac.getBean("userService", IUserService.class);
        System.out.println(us.login("admin", "123456"));
        ac.close();
    }

    @Test
    public void testUpdateUser(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        UserMapper um = ac.getBean("userMapper", UserMapper.class);
        User user = new User();
        user.setId(6);
        // user.setPassword("222222");
        user.setUsername("MariaLee");
        user.setGender(1);
        user.setPhone("10086");
        user.setEmail("new@tedu.cn");
        um.updateUser(user);
        ac.close();
    }

    @Test
    public void testSelectById() {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        UserMapper um = ac.getBean("userMapper", UserMapper.class);
        System.out.println(um.selectUserById(6));
        ac.close();
    }

    @Test
    public void testChangePassword(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IUserService us = ac.getBean("userService", IUserService.class);
        us.changePassword(6, "111111", "112111");
        ac.close();
    }

    @Test
    public void testUpdateU(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IUserService us = ac.getBean("userService", IUserService.class);
        us.updateUser(5, "jackma", 0, "13800138888", "jack@tedu.cn");
        ac.close();
    }

    @Test
    public void testUpdateImage(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        // UserMapper um = ac.getBean("userMapper", UserMapper.class);
        IUserService us = ac.getBean("userService", IUserService.class);
        us.updateImage("/upload/xxx.jpg", 5);
        ac.close();
    }



}
