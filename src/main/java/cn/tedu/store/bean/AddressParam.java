package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Objects;

public class AddressParam implements Serializable {

    private static final long serialVersionUID = -8588338112924768374L;
    private Integer id;
    private String receiverName;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverMobile;
    private String receiverPhone;
    private String receiverZip;
    private String addressName;

    public AddressParam() {
    }

    public AddressParam(Integer id, String receiverName, String receiverState, String receiverCity, String receiverDistrict, String receiverAddress, String receiverMobile, String receiverPhone, String receiverZip, String addressName) {
        this.id = id;
        this.receiverName = receiverName;
        this.receiverState = receiverState;
        this.receiverCity = receiverCity;
        this.receiverDistrict = receiverDistrict;
        this.receiverAddress = receiverAddress;
        this.receiverMobile = receiverMobile;
        this.receiverPhone = receiverPhone;
        this.receiverZip = receiverZip;
        this.addressName = addressName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressParam)) return false;
        AddressParam that = (AddressParam) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(receiverName, that.receiverName) &&
                Objects.equals(receiverState, that.receiverState) &&
                Objects.equals(receiverCity, that.receiverCity) &&
                Objects.equals(receiverDistrict, that.receiverDistrict) &&
                Objects.equals(receiverAddress, that.receiverAddress) &&
                Objects.equals(receiverMobile, that.receiverMobile) &&
                Objects.equals(receiverPhone, that.receiverPhone) &&
                Objects.equals(receiverZip, that.receiverZip) &&
                Objects.equals(addressName, that.addressName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, receiverName, receiverState, receiverCity, receiverDistrict, receiverAddress, receiverMobile, receiverPhone, receiverZip, addressName);
    }

    @Override
    public String toString() {
        return "AddressParam{" +
                "id=" + id +
                ", receiverName='" + receiverName + '\'' +
                ", receiverState='" + receiverState + '\'' +
                ", receiverCity='" + receiverCity + '\'' +
                ", receiverDistrict='" + receiverDistrict + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverZip='" + receiverZip + '\'' +
                ", addressName='" + addressName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
