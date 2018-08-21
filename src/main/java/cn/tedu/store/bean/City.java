package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {

    private static final long serialVersionUID = -5277015795040497226L;

    private Integer id;
    private String provinceCode;
    private String cityCode;
    private String cityName;

    public City() {
    }

    public City(Integer id, String provinceCode, String cityCode, String cityName) {
        this.id = id;
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(provinceCode, city.provinceCode) &&
                Objects.equals(cityCode, city.cityCode) &&
                Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, provinceCode, cityCode, cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }


}
