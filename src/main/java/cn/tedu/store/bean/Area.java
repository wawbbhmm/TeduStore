package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Objects;

public class Area implements Serializable {

    private static final long serialVersionUID = -8719339816778424301L;
    private Integer id;
    private String cityCode;
    private String areaCode;
    private String areaName;

    public Area() {
    }

    public Area(Integer id, String cityCode, String areaCode, String areaName) {
        this.id = id;
        this.cityCode = cityCode;
        this.areaCode = areaCode;
        this.areaName = areaName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id) &&
                Objects.equals(cityCode, area.cityCode) &&
                Objects.equals(areaCode, area.areaCode) &&
                Objects.equals(areaName, area.areaName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cityCode, areaCode, areaName);
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", cityCode='" + cityCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }


}
