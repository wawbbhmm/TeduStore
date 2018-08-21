package cn.tedu.store.controller;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 省市几乎不该，但经常查询，应放在Redis中缓冲
 */
@Controller
@RequestMapping("/dict")
public class DictController {

    @Resource
    private IDictService dictService;

    /**
     * 显示省信息
     * @return
     */
    @RequestMapping("/getProvince.do")
    @ResponseBody
    public ResponseResult<List<Province>> getProvince(){
        //1.创建rr对象
        ResponseResult<List<Province>> rr = new ResponseResult<>();
        //2.调用业务层的方法;返回list集合
        List<Province> list = dictService.getProvince();
        //3.把list设置到rr对象中
        rr.setData(list);
        //4.state = 1; message = "成功"
        rr.setState(1);
        rr.setMessage("成功！");
        return rr;
    }

    /**
     * 显示城市信息
     * @param provinceCode
     * @return
     */
    @RequestMapping("/getCity.do")
    @ResponseBody
    public ResponseResult<List<City>> getCity(String provinceCode){
        //1.创建rr对象
        ResponseResult<List<City>> rr = new ResponseResult<>();
        //2.调用业务层方法;返回list
        List<City> list = dictService.getCity(provinceCode);
        //3.把list设置到data属性
        rr.setData(list);
        //4.state = 1;message="成功"
        rr.setState(1);
        rr.setMessage("成功！");
        return rr;
    }

    /**
     * 显示区域信息
     * @param cityCode
     * @return
     */
    @RequestMapping("/getArea.do")
    @ResponseBody
    public ResponseResult<List<Area>> getArea(String cityCode){
        //1.创建rr对象
        ResponseResult<List<Area>> rr = new ResponseResult<>();
        //2.调用业务层方法,返回list
        List<Area> list = dictService.getArea(cityCode);
        //3.把list集合设置到rr对象
        rr.setData(list);
        //4.state = 1;message ="成功"
        rr.setState(1);
        rr.setMessage("成功！");
        return rr;
    }

}
