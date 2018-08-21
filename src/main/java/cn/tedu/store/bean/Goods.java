package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Objects;

public class Goods implements Serializable {

    private static final long serialVersionUID = 8747034229062577681L;
    private String id; // 主键
    private Integer categoryId; // 分类id
    private String itemType; // 商品型号
    private String title; // 商品的名称
    private String sellPoint; // 卖点
    private Integer price; // 价格
    private Integer num; // 库存
    private String barcode; // 条形码
    private String image; // 图片路径
    private Integer status; // 商品状态
    private Integer priority; // 优先级
    private String createdUser;
    private String createdTime;
    private String modifiedUser;
    private String modifiedTime;

    public Goods() {
    }

    public Goods(String id, Integer categoryId, String itemType, String title, String sellPoint, Integer price, Integer num, String barcode, String image, Integer status, Integer priority, String createdUser, String createdTime, String modifiedUser, String modifiedTime) {
        this.id = id;
        this.categoryId = categoryId;
        this.itemType = itemType;
        this.title = title;
        this.sellPoint = sellPoint;
        this.price = price;
        this.num = num;
        this.barcode = barcode;
        this.image = image;
        this.status = status;
        this.priority = priority;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) &&
                Objects.equals(categoryId, goods.categoryId) &&
                Objects.equals(itemType, goods.itemType) &&
                Objects.equals(title, goods.title) &&
                Objects.equals(sellPoint, goods.sellPoint) &&
                Objects.equals(price, goods.price) &&
                Objects.equals(num, goods.num) &&
                Objects.equals(barcode, goods.barcode) &&
                Objects.equals(image, goods.image) &&
                Objects.equals(status, goods.status) &&
                Objects.equals(priority, goods.priority) &&
                Objects.equals(createdUser, goods.createdUser) &&
                Objects.equals(createdTime, goods.createdTime) &&
                Objects.equals(modifiedUser, goods.modifiedUser) &&
                Objects.equals(modifiedTime, goods.modifiedTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, categoryId, itemType, title, sellPoint, price, num, barcode, image, status, priority, createdUser, createdTime, modifiedUser, modifiedTime);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", categoryId=" + categoryId +
                ", itemType='" + itemType + '\'' +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", barcode='" + barcode + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }


}
