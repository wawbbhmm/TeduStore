package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Objects;

public class Province implements Serializable {

    private static final long serialVersionUID = 1743509421168233065L;
    private Integer id;
    private String provinceCode;
    private String provinceName;

    public Province() {
    }

    public Province(Integer id, String provinceCode, String provinceName) {
        this.id = id;
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
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

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Province)) return false;
        Province province = (Province) o;
        return Objects.equals(id, province.id) &&
                Objects.equals(provinceCode, province.provinceCode) &&
                Objects.equals(provinceName, province.provinceName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, provinceCode, provinceName);
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provinceCode='" + provinceCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }

}
