package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {

    /**
     * 注册功能的方法
     * @param user 封装了页面数据的对象
     */
    void register(User user); // 接口里方法可以不写public，因为实现的时候访问权限必须大于接口中，实现类里必须写public

    /**
     * 验证邮箱是否存在
     * @param email
     * @return 如果存在，返回true，否则返回false
     */
    boolean checkEmail(String email);

    /**
     * 手机号码验证
     * @param phone
     * @return
     */
    boolean checkPhone(String phone);

    /**
     * 用户名验证
     * @param username
     * @return 如果是null，返回false，否则发挥true
     */
    boolean checkUsername(String username);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return 登录成功返回user，否则抛出异常：UserNotFoundException & PasswordNotMatchException
     */
    User login(String username,String password);

    /**
     * 修改密码
     * @param id
     * @param oldPwd
     * @param newPwd
     */
    void changePassword(Integer id, String oldPwd, String newPwd);

    /**
     * 修改个人信息
     * @param id
     * @param username
     * @param gender
     * @param phone
     * @param email
     */
    void updateUser(Integer id, String username, Integer gender, String phone, String email);

    /**
     * 通过id返回 用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 修改头像
     * @param image
     * @param id
     */
    void updateImage(String image, Integer id);





}
