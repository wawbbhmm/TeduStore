package cn.tedu.store.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 值对象ValueObject
 */
public class CartVo implements Serializable {

    private static final long serialVersionUID = -3606121795279097315L;
    private Integer id;
    private Integer uid;
    private String goodsId;
    private Integer num;
    private String image;
    private String title;
    private Integer price;

    public CartVo() {
    }

    public CartVo(Integer id, Integer uid, String goodsId, Integer num, String image, String title, Integer price) {
        this.id = id;
        this.uid = uid;
        this.goodsId = goodsId;
        this.num = num;
        this.image = image;
        this.title = title;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartVo)) return false;
        CartVo cartVo = (CartVo) o;
        return Objects.equals(id, cartVo.id) &&
                Objects.equals(uid, cartVo.uid) &&
                Objects.equals(goodsId, cartVo.goodsId) &&
                Objects.equals(num, cartVo.num) &&
                Objects.equals(image, cartVo.image) &&
                Objects.equals(title, cartVo.title) &&
                Objects.equals(price, cartVo.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uid, goodsId, num, image, title, price);
    }

    @Override
    public String toString() {
        return "CartVo{" +
                "id=" + id +
                ", uid=" + uid +
                ", goodsId='" + goodsId + '\'' +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
