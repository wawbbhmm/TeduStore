package cn.tedu.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author Theo
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在controller方法之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //1.判断session中有没有user对象
        HttpSession session = httpServletRequest.getSession();
        Object obj = session.getAttribute("user");
        //2.如果有 return true;
        if (obj != null) {
            return true;
        } else {
            //3.如果没有 重定向的到登录页面
            String url = httpServletRequest.getContextPath() + "/user/showLogin.do";
            httpServletResponse.sendRedirect(url);
            return false;
        }
    }

    /**
     * 控制器方法执行完成，但是没有响应视图
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 视图响应成功之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
