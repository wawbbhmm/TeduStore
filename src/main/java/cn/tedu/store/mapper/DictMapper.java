package cn.tedu.store.mapper;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

import java.util.List;

public interface DictMapper {

    /**
     * 查询省份信息
     * @return
     */
    List<Province> selectProvince();

    /**
     * 查询城市信息
     * @param provinceCode
     * @return
     */
    List<City> selectCity(String provinceCode);

    /**
     * 查询区域信息
     * @param cityCode
     * @return
     */
    List<Area> selectArea(String cityCode);

    /**
     * 查询省名称
     * @param provinceCode
     * @return
     */
    String selectProvinceNameByCode(String provinceCode);

    /**
     * 查询城市名称
     * @param cityCode
     * @return
     */
    String selectCityNameByCode(String cityCode);

    /**
     * 查询区域名称
     * @param areaCode
     * @return
     */
    String selectAreaNameByCode(String areaCode);



}
