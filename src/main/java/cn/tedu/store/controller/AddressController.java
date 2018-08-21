package cn.tedu.store.controller;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.AddressParam;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {

    @Resource
    private IAddressService addressService;

    /**
     * 显示地址页面
     * @return
     */
    @RequestMapping("/showAddress.do")
    public String showAddress(){
        return "addressAdmin";
    }

    /**
     * 添加收货地址信息
     * @param session
     * @param recvUsername
     * @param recvProvinceCode
     * @param recvCityCode
     * @param recvAreaCode
     * @param recvAddress
     * @param recvPhone
     * @param recvTel
     * @param recvZip
     * @param recvTag
     * @return
     */
    @RequestMapping("/addAddress.do")
    @ResponseBody
    public ResponseResult<Void> addAddress(HttpSession session,
            @RequestParam("receiverName") String recvUsername,
            @RequestParam("receiverState") String recvProvinceCode,
            @RequestParam("receiverCity") String recvCityCode,
            @RequestParam("receiverDistrict") String recvAreaCode,
            @RequestParam("receiverAddress") String recvAddress,
            @RequestParam("receiverMobile") String recvPhone,
            @RequestParam("receiverPhone") String recvTel,
            @RequestParam("receiverZip") String recvZip,
            @RequestParam("addressName") String recvTag){
        //1.创建rr对象
        ResponseResult<Void> rr = new ResponseResult<Void>();
        //2.调用业务层方法addAddress(address);
        Address address = new Address();
        address.setUid(this.getId(session));
        address.setRecvUsername(recvUsername);
        address.setRecvProvinceCode(recvProvinceCode);
        address.setRecvCityCode(recvCityCode);
        address.setRecvAreaCode(recvAreaCode);
        address.setRecvAddress(recvAddress);
        address.setRecvPhone(recvPhone);
        address.setRecvTel(recvTel);
        address.setRecvZip(recvZip);
        address.setRecvTag(recvTag);
        addressService.addAddress(address);
        //3.state = 1 message = "添加成功"
        rr.setState(1);
        rr.setMessage("添加成功！");
        return rr;
    }

    /**
     * 显示收货地址信息
     * @param session
     * @return
     */
    @RequestMapping("/getAddressByUid.do")
    @ResponseBody
    public ResponseResult<List<Address>> getAddressByUid(HttpSession   session){
        //1.创建rr对象
        ResponseResult<List<Address>> rr = new ResponseResult<>();
        //2.调用业务层方法;返回list,把集合设置到rr对象中.
        List<Address> list = addressService.getAddressByUid(this.getId(session));
        rr.setData(list);
        //3.state = 1 ;message="成功";
        rr.setState(1);
        rr.setMessage("成功！");
        return rr;
    }

    /**
     * 设置默认收货地址
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/setDefault.do")
    @ResponseBody
    public ResponseResult<Void> setDefault(HttpSession session,Integer id){
        //1.创建rr对象
        ResponseResult<Void> rr = new ResponseResult<>();
        try{
            //2.调用业务层方法
            addressService.setDefault(this.getId(session), id);
            //state = 1;message ="";
            rr.setState(1);
            rr.setMessage("成功！");
        }catch(RuntimeException e){
            //state = 0;message=e.getMessage();
            rr.setState(0);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }

    /**
     * 显示收货人地址信息
     * @param id
     * @return
     */
    @RequestMapping("/goUpdate.do")
    @ResponseBody
    public ResponseResult<Address> goUpdate(Integer id){
        //1.创建rr对象
        ResponseResult<Address> rr = new ResponseResult<>();
        //2.调用业务层方法;返回address对象,把address设置到rr对象中
        Address address = addressService.getAddressById(id);
        rr.setData(address);
        //3.state = 1;message ="成功";
        rr.setState(1);
        rr.setMessage("成功！");
        return rr;
    }

    /**
     * 修改地址信息
     * @param ap
     * @return
     */
    @RequestMapping("/updateAddress.do")
    @ResponseBody
    public ResponseResult<Void> updateAddress(AddressParam ap){
        ResponseResult<Void> rr = new ResponseResult<>();
        Address address = new Address();
        address.setId(ap.getId());
        address.setRecvUsername(ap.getReceiverName());
        address.setRecvProvinceCode(ap.getReceiverState());
        address.setRecvCityCode(ap.getReceiverCity());
        address.setRecvAreaCode(ap.getReceiverDistrict());
        address.setRecvAddress(ap.getReceiverAddress());
        address.setRecvPhone(ap.getReceiverMobile());
        address.setRecvTel(ap.getReceiverPhone());
        address.setRecvZip(ap.getReceiverZip());
        address.setRecvTag(ap.getAddressName());
        addressService.updAddress(address);
        rr.setState(1);
        rr.setMessage("成功！");
        return rr;
    }

    /**
     * 删除收货人地址
     * @param id
     * @return
     */
    @RequestMapping("/deleteAddress.do")
    @ResponseBody
    public ResponseResult<Void> deleteAddress(Integer id){
        //1.创建rr对象
        ResponseResult<Void> rr = new ResponseResult<>();
        //2.调用业务层方法
        addressService.deleteAddress(id);
        //3.state = 1;message="成功"
        rr.setState(1);
        rr.setMessage("成功！");
        return rr;
    }




}
