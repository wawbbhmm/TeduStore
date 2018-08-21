package cn.tedu.store.service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional // 当前类所有方法通过事务处理，方法出现"运行时异常"时自动回滚
public class AddressService implements IAddressService {

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private DictMapper dictMapper;

    /**
     * 获取省市区的名称
     * @param address
     * @return
     */
    private String getLoc(Address address){
        String loc = dictMapper.selectProvinceNameByCode(address.getRecvProvinceCode()) +
                dictMapper.selectCityNameByCode(address.getRecvCityCode()) +
                dictMapper.selectAreaNameByCode(address.getRecvAreaCode());
        return loc;
    }

    @Override
    public void addAddress(Address address) {
        // 调用dictMapper接口中的方法,通过code获取name,把3个name用+连接成一个字符串,把该字符串设置到recvDeistrict中.
        // String loc = dictMapper.selectProvinceNameByCode(address.getRecvProvinceCode()) +
        //         dictMapper.selectCityNameByCode(address.getRecvCityCode()) +
        //         dictMapper.selectAreaNameByCode(address.getRecvAreaCode());
        //1.设置recvDeistrict值
        address.setRecvDistrict(getLoc(address));
        //2.给isDefault属性设置值: 0表示非默认 1表示默认
        //list.size()>0  isDefault = 0
        //list.size()=0  isDefault = 1
        List<Address> list = addressMapper.selectAddressByUid(address.getUid());
        if(list.size() > 0){
            address.setIsDefault(0);
        }else {
            address.setIsDefault(1);
        }
        //3.addressMapper.insertAddress(address);
        addressMapper.insertAddress(address);
    }

    @Override
    public List<Address> getAddressByUid(Integer uid) {
        return addressMapper.selectAddressByUid(uid);
    }

    @Override
    public void setDefault(Integer uid, Integer id) {
        //1.调用updateCancel方法,返回int的值n1
        Integer n1 = addressMapper.updateCancel(uid);
        //如果n1==0,抛出异常RuntimeException("修改失败");
        if(n1 == 0){
            throw new RuntimeException("修改失败！");
        }
        //2.调用updateDefault()方法,返回int的值n2
        Integer n2 = addressMapper.updateDefault(id);
        //如果n2==0,抛出异常RuntimeException("修改失败");
        if(n2 == 0){
            throw new RuntimeException("修改失败！");
        }
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressMapper.selectAddressById(id);
    }

    @Override
    public void updAddress(Address address) {
        address.setRecvDistrict(getLoc(address));
        addressMapper.updateAddress(address);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressMapper.deleteAddress(id);
    }


}
