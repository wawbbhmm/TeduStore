package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService {

    // 提倡用Resource进行依赖注入（给成员变量赋值），不用springMVC的Autowire
    @Resource
    private UserMapper userMapper;

    private String salt = "WorldKing";

    @Override
    public void register(User user) {
        // 判断用户名是否存在，如果不存在，实现插入操作；如果存在抛出异常
        if (userMapper.selectUserByUsername(user.getUsername()) == null){
            // 明文的密码
            String pwd = user.getPassword();
            // 生成密文
            String pwdMd5 = DigestUtils.md5Hex(pwd+salt);
            // user对象中设置密文
            user.setPassword(pwdMd5);
            userMapper.insertUser(user);
        } else {
            throw new UsernameAlreadyExistException("用户名已存在！");
        }
    }

    @Override
    public boolean checkEmail(String email) {
        // 如果有返回true，否则返回false
        return userMapper.selectByEmail(email) > 0;
    }

    @Override
    public boolean checkPhone(String phone) {
        return userMapper.selectByPhone(phone) > 0;
    }

    @Override
    public boolean checkUsername(String username) {
        System.out.println("UserService.checkUsername");
        // 调用持久层方法
        User user = userMapper.selectUserByUsername(username);
        // 判断返回值是否为null
        if(user == null){
            // 如果为null，返回false
            return false;
        }else {
            // 否则返回true
            return true;
        }
    }

    @Override
    public User login(String username, String password) {
        System.out.println("UserService.login");
        //1.调用持久层方法selectUserByUsername(username);
        User user = userMapper.selectUserByUsername(username);
        //2.判断user对象是否为null
        if(user == null){
            //3.user==null,抛出异常,UserNotFoundException;
            throw new UserNotFoundException("该用户不存在");
        }else {
            //4.user!=null,从user对象中获取password,和参数列表中的password比较
            //把密码处理成密文和数据库的密文进行比较
            String strMd5 = DigestUtils.md5Hex(password+salt);
            if(user.getPassword().equals(strMd5)){
                //5.如果是true，返回user
                return user;
            }else {
                //6.密码比较,两种情况:密码相同;返回 user对象;如果密码不相同,抛出异常PasswordNotMatchException
                throw new PasswordNotMatchException("密码不匹配！");
            }
        }
    }

    @Override
    public void changePassword(Integer id, String oldPwd, String newPwd) {
        //1.调用持久层的方法selectUserById(id);返回user对象;
        User user = userMapper.selectUserById(id);
        if(user == null){
            //2.user==null;抛出异常UserNotFoundException;
            throw new UserNotFoundException("用户不存在！");
        }else {
            //3.user!=null;从user对象中获取password,和页面上的oldPwd比较
            // 把oldPwd编程密文进行比较
            String oldMd5 = DigestUtils.md5Hex(oldPwd+salt);
            if(user.getPassword().equals(oldMd5)){
                //4.如果密码相同,调用持久层的方法,updateUser(user1),user1对象中封装id,和newPwd;
                User user1 = new User();
                user1.setId(id);
                String newMd5 = DigestUtils.md5Hex(newPwd+salt);
                user1.setPassword(newMd5);
                userMapper.updateUser(user1);
            }else {
                //5.如果密码不相同,抛出异常PasswordNotMatchException;
                throw new PasswordNotMatchException("密码不匹配！");
            }
        }
    }

    @Override
    public void updateUser(Integer id, String username, Integer gender, String phone, String email) {
        User newUser = new User();
        newUser.setId(id);
        newUser.setGender(gender);
        newUser.setPhone(phone);
        newUser.setEmail(email);
        //根据id查询;返回user对象
        User user = userMapper.selectUserById(id);
        if(user == null){
            //如果user==null;抛出异常
            throw new UserNotFoundException("用户不存在！");
        }else{
            //根据用户名查询;返回user1
            User user1 = userMapper.selectUserByUsername(username);
            if(user1 != null){
                //当前的用户名就是登陆的用户名
                if(user1.getUsername().equals(user.getUsername())){
                }else{
                    //否则抛出异常
                    throw new UsernameAlreadyExistException("用户名已存在！");
                }
            }else{
                //数据库中没有相同的用户名,
                //设置用户名为newUser的属性.
                newUser.setUsername(username);
            }
            //修改用户信息
            userMapper.updateUser(newUser);
        }
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void updateImage(String image, Integer id) {
        userMapper.updateImage(image, id);
    }


}
