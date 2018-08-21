package test;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAddress {

    @Test
    public void testInsertAddresss(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        AddressMapper am = ac.getBean("addressMapper", AddressMapper.class);
        Address address = new Address();
        address.setUid(3);
        address.setRecvUsername("小刘");
        address.setRecvProvinceCode("130000");
        address.setRecvCityCode("130100");
        address.setRecvAreaCode("130102");
        address.setRecvAddress("中鼎8层");
        address.setRecvDistrict("河北省石家庄市长安区");
        address.setRecvPhone("13800138000");
        address.setRecvTel("10086");
        address.setRecvZip("100000");
        address.setRecvTag("公司");
        address.setIsDefault(1);
        am.insertAddress(address);
        ac.close();
    }

    @Test
    public void testSelectByUid(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        AddressMapper am = ac.getBean("addressMapper", AddressMapper.class);
        System.out.println(am.selectAddressByUid(3));
        ac.close();
    }

    @Test
    public void testAddAddress(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IAddressService as = ac.getBean("addressService", IAddressService.class);
        Address address = new Address();
        address.setUid(3);
        address.setRecvUsername("小王");
        address.setRecvProvinceCode("130000");
        address.setRecvCityCode("130100");
        address.setRecvAreaCode("130102");
        address.setRecvAddress("中鼎8层");
        address.setRecvDistrict("河北省石家庄市长安区");
        address.setRecvPhone("13900139000");
        address.setRecvTel("110");
        address.setRecvZip("000000");
        address.setRecvTag("公司");
        as.addAddress(address);
        ac.close();
    }

    @Test
    public void testDefault(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        AddressMapper am = ac.getBean("addressMapper", AddressMapper.class);
        am.updateCancel(5);
        am.updateDefault(3);
        ac.close();
    }

    @Test
    public void testSetDefault(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IAddressService as = ac.getBean("addressService", IAddressService.class);
        as.setDefault(5, 2);
    }

    @Test
    public void testSelectById(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        ac.getBean("addressMapper", AddressMapper.class);
        // AddressMapper am = ac.getBean("addressMapper", AddressMapper.class);
        // System.out.println(am.selectAddressById(5));
        IAddressService as = ac.getBean("addressService", IAddressService.class);
        System.out.println(as.getAddressById(5));
        ac.close();
    }

    @Test
    public void testUpdateAddress(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        AddressMapper am = ac.getBean("addressMapper", AddressMapper.class);
        Address address = new Address();
        address.setId(2);
        address.setRecvUsername("小高");
        address.setRecvProvinceCode("130000");
        address.setRecvCityCode("130100");
        address.setRecvAreaCode("130102");
        address.setRecvAddress("中鼎大厦3层");
        address.setRecvDistrict("河北省石家庄市长安区");
        address.setRecvPhone("12345678912");
        address.setRecvTel("119");
        address.setRecvZip("100039");
        address.setRecvTag("家");
        am.updateAddress(address);
        ac.close();
    }

    @Test
    public void testUpdAddress(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IAddressService as = ac.getBean("addressService", IAddressService.class);
        Address address = new Address();
        address.setId(3);
        address.setRecvUsername("小高");
        address.setRecvProvinceCode("130000");
        address.setRecvCityCode("130100");
        address.setRecvAreaCode("130102");
        address.setRecvAddress("中鼎大厦3层");
        address.setRecvPhone("12345678912");
        address.setRecvTel("119");
        address.setRecvZip("100039");
        address.setRecvTag("家");
        as.updAddress(address);
        ac.close();
    }

    @Test
    public void testDel(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        // AddressMapper am = ac.getBean("addressMapper", AddressMapper.class);
        // am.deleteAddress(6);
        IAddressService as = ac.getBean("addressService", IAddressService.class);
        as.deleteAddress(7);
        ac.close();
    }


}
