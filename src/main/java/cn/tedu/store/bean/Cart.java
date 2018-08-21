package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Cart implements Serializable {

    private static final long serialVersionUID = 812218087679890106L;
    private Integer id;
    private Integer uid;
    private String goodsId;
    private Integer num;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

    public Cart() {
    }

    public Cart(Integer id, Integer uid, String goodsId, Integer num, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        this.id = id;
        this.uid = uid;
        this.goodsId = goodsId;
        this.num = num;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(uid, cart.uid) &&
                Objects.equals(goodsId, cart.goodsId) &&
                Objects.equals(num, cart.num) &&
                Objects.equals(createdUser, cart.createdUser) &&
                Objects.equals(createdTime, cart.createdTime) &&
                Objects.equals(modifiedUser, cart.modifiedUser) &&
                Objects.equals(modifiedTime, cart.modifiedTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uid, goodsId, num, createdUser, createdTime, modifiedUser, modifiedTime);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", uid=" + uid +
                ", goodsId='" + goodsId + '\'' +
                ", num=" + num +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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
