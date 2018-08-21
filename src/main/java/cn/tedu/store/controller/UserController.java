package cn.tedu.store.controller;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    /**
     * 显示页面
     * @return
     */
    @RequestMapping("/showRegister.do")
    public String showRegister(){
        return "register";
    }

    /**
     * 显示登陆页面
     * @return 视图(view)组件名称
     */
    @RequestMapping("/showLogin.do")
    public String showLogin(){
        return "login";
    }

    /**
     * 显示修改密码的页面
     * @return
     */
    @RequestMapping("/showPassword.do")
    public String showPassword(){
        return "personal_password";
    }

    /**
     * 显示修改个人信息
     * @return
     */
    @RequestMapping("/showPersonInfo.do")
    public String showPersonInfo(){
        return "personPage";
    }

    /**
     * 验证用户名是否可用
     * @param username
     * @return
     */
    @RequestMapping("/checkUsername.do")
    @ResponseBody
    public ResponseResult<Void> checkUsername(String username){
        ResponseResult<Void> rr = new ResponseResult<>();
        if(userService.checkUsername(username)){
            rr.setState(0);
            rr.setMessage("用户名已存在！");
        }else {
            rr.setState(1);
            rr.setMessage("用户名可以使用！");
        }
        return rr;
    }

    @RequestMapping("/checkEmail.do")
    @ResponseBody
    public ResponseResult<Void> checkEmail(String email){
        ResponseResult<Void> rr = new ResponseResult<>();
        if(userService.checkEmail(email)){
            rr.setState(0);
            rr.setMessage("邮箱已存在！");
        }else {
            rr.setState(1);
            rr.setMessage("邮箱可以使用！");
        }
        return rr;
    }

    @RequestMapping("/checkPhone.do")
    @ResponseBody
    public ResponseResult<Void> checkPhone(String phone){
        ResponseResult<Void> rr = new ResponseResult<>();
        if(userService.checkPhone(phone)){
            rr.setState(0);
            rr.setMessage("手机号已存在！");
        }else {
            rr.setState(1);
            rr.setMessage("手机号可以使用！");
        }
        return rr;
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @param email
     * @param phone
     * @return
     */
    @RequestMapping("/register.do")
    @ResponseBody
    public ResponseResult<Void> register(
            @RequestParam("uname") String username,
            @RequestParam("upwd") String password,
            String email, String phone){
        ResponseResult<Void> rr = new ResponseResult<>();
        // 创建rr对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        try {
            // 调用业务层方法
            userService.register(user);
            rr.setState(1);
            rr.setMessage("注册成功！");
        } catch (UsernameAlreadyExistException e) {
            // 如果有异常，封装信息到rr对象
            rr.setState(0);
            rr.setMessage("用户名已经存在！");
        }
        return rr;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public ResponseResult<Void> login(String username, String password, HttpSession session){
        //1.创建rr对象
        ResponseResult<Void> rr = new ResponseResult<>();
        try{
            //2.调用业务层方法login(username,password);返回user对象;把user对象设置到session中.
            User user = userService.login(username, password);
            session.setAttribute("user", user);
            //3.state = 1 message = "登录成功"
            rr.setState(1);
            rr.setMessage("登录成功");
        }catch(RuntimeException e){ // 如果两个catch从上到下的顺序也只能捕获一个异常
            //4.state = 0 message = e.getMessage()
            rr.setState(0);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/exit.do")
    public String exit(HttpSession session){
        //1.session 失效
        session.invalidate();
        //2.重定向到首页
        return "redirect:../main/showIndex.do";
    }

    /**
     * 修改密码
     * @param session
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping("/updatePassword.do")
    @ResponseBody
    public ResponseResult<Void> updatePassword(HttpSession session, String oldPwd, String newPwd){
        //1.创建rr对象
        ResponseResult<Void> rr = new ResponseResult<>();
        try{
            //id 从session中获取 this.getId(session)
            //2.调用业务层的方法changePassword(id,oldPwd,newPwd);
            userService.changePassword(this.getId(session), oldPwd, newPwd);
            //state = 1;message ="修改密码成功"
            rr.setState(1);
            rr.setMessage("修改成功！");
        }catch(RuntimeException e){
            //state = 0;message =e.getMessage();
            rr.setState(0);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }

    /**
     * 修改个人信息
     * @param session
     * @param username
     * @param gender
     * @param phone
     * @param email
     * @return
     */
    @RequestMapping("/updateUser.do")
    @ResponseBody
    public ResponseResult<Void> updateUser(
            HttpSession session,String username,
            Integer gender,String phone,String email){
        //1.创建rr对象
        ResponseResult<Void> rr = new ResponseResult<>();
        try{
            // 调用业务层方法
            userService.updateUser(this.getId(session), username, gender, phone, email);
            // 获取user对象
            User user = userService.getUserById(this.getId(session));
            // 重新设置(覆盖)session的user对象
            session.setAttribute("user", user);
            // state = 1 ;message="修改成功"
            rr.setState(1);
            rr.setMessage("修改成功");
        }catch(RuntimeException e){
            // state = 0; message = e.getMassage();
            rr.setState(0);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }

    /**
     * 上传图片
     * @param file
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload.do")
    @ResponseBody
    public ResponseResult<Void> upload(
            @RequestParam("file") MultipartFile file,
            HttpSession session) throws Exception{
        ResponseResult<Void> rr = new ResponseResult<Void>();
        // 获取服务器的真实路径
        String path = session.getServletContext().getRealPath("/");
        System.out.println(path);
        // 上传
        file.transferTo(new File(path,"/upload/" + file.getOriginalFilename()));
        // 保存头像
        userService.updateImage("/upload/" + file.getOriginalFilename(), this.getId(session));
        //更新session中的user对象
        session.setAttribute("user", userService.getUserById(this.getId(session)));

        rr.setState(1);
        rr.setMessage("上传图片成功！");
        return rr;
    }





}
