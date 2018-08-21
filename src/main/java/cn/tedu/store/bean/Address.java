package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Address implements Serializable {

    private static final long serialVersionUID = 2440169729997559533L;

    private Integer id;
    private Integer uid;
    private String recvUsername;
    private String recvProvinceCode;
    private String recvCityCode;
    private String recvAreaCode;
    private String recvAddress;
    private String recvDistrict;
    private String recvPhone;
    private String recvTel;
    private String recvZip;
    private String recvTag;
    private Integer isDefault;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

    public Address() {
    }

    public Address(Integer id, Integer uid, String recvUsername, String recvProvinceCode, String recvCityCode, String recvAreaCode, String recvAddress, String recvDistrict, String recvPhone, String recvTel, String recvZip, String recvTag, Integer isDefault, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        this.id = id;
        this.uid = uid;
        this.recvUsername = recvUsername;
        this.recvProvinceCode = recvProvinceCode;
        this.recvCityCode = recvCityCode;
        this.recvAreaCode = recvAreaCode;
        this.recvAddress = recvAddress;
        this.recvDistrict = recvDistrict;
        this.recvPhone = recvPhone;
        this.recvTel = recvTel;
        this.recvZip = recvZip;
        this.recvTag = recvTag;
        this.isDefault = isDefault;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", uid=" + uid +
                ", recvUsername='" + recvUsername + '\'' +
                ", recvProvinceCode='" + recvProvinceCode + '\'' +
                ", recvCityCode='" + recvCityCode + '\'' +
                ", recvAreaCode='" + recvAreaCode + '\'' +
                ", recvAddress='" + recvAddress + '\'' +
                ", recvDistrict='" + recvDistrict + '\'' +
                ", recvPhone='" + recvPhone + '\'' +
                ", recvTel='" + recvTel + '\'' +
                ", recvZip='" + recvZip + '\'' +
                ", recvTag='" + recvTag + '\'' +
                ", isDefault=" + isDefault +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(uid, address.uid) &&
                Objects.equals(recvUsername, address.recvUsername) &&
                Objects.equals(recvProvinceCode, address.recvProvinceCode) &&
                Objects.equals(recvCityCode, address.recvCityCode) &&
                Objects.equals(recvAreaCode, address.recvAreaCode) &&
                Objects.equals(recvAddress, address.recvAddress) &&
                Objects.equals(recvDistrict, address.recvDistrict) &&
                Objects.equals(recvPhone, address.recvPhone) &&
                Objects.equals(recvTel, address.recvTel) &&
                Objects.equals(recvZip, address.recvZip) &&
                Objects.equals(recvTag, address.recvTag) &&
                Objects.equals(isDefault, address.isDefault) &&
                Objects.equals(createdUser, address.createdUser) &&
                Objects.equals(createdTime, address.createdTime) &&
                Objects.equals(modifiedUser, address.modifiedUser) &&
                Objects.equals(modifiedTime, address.modifiedTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uid, recvUsername, recvProvinceCode, recvCityCode, recvAreaCode, recvAddress, recvDistrict, recvPhone, recvTel, recvZip, recvTag, isDefault, createdUser, createdTime, modifiedUser, modifiedTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRecvUsername() {
        return recvUsername;
    }

    public void setRecvUsername(String recvUsername) {
        this.recvUsername = recvUsername;
    }

    public String getRecvProvinceCode() {
        return recvProvinceCode;
    }

    public void setRecvProvinceCode(String recvProvinceCode) {
        this.recvProvinceCode = recvProvinceCode;
    }

    public String getRecvCityCode() {
        return recvCityCode;
    }

    public void setRecvCityCode(String recvCityCode) {
        this.recvCityCode = recvCityCode;
    }

    public String getRecvAreaCode() {
        return recvAreaCode;
    }

    public void setRecvAreaCode(String recvAreaCode) {
        this.recvAreaCode = recvAreaCode;
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }

    public String getRecvDistrict() {
        return recvDistrict;
    }

    public void setRecvDistrict(String recvDistrict) {
        this.recvDistrict = recvDistrict;
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }

    public String getRecvTel() {
        return recvTel;
    }

    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel;
    }

    public String getRecvZip() {
        return recvZip;
    }

    public void setRecvZip(String recvZip) {
        this.recvZip = recvZip;
    }

    public String getRecvTag() {
        return recvTag;
    }

    public void setRecvTag(String recvTag) {
        this.recvTag = recvTag;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }


}
