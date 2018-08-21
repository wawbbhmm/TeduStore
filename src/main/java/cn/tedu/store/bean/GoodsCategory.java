package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Objects;

public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = -4112281369212857631L;
    private Integer id; // 分类表的主键列
    private Integer parentId; // 父分类，如果是0表示一级分类
    private String name; // 分类名称
    private String status; // 分类状态，1表示正常，2表示删除
    private String sortOrder; // 排序号
    private String isParent; // 是否是父分类
    private String createdUser;
    private String createdTime;
    private String modifiedUser;
    private String modifiedTime;

    public GoodsCategory() {
    }

    public GoodsCategory(Integer id, Integer parentId, String name, String status, String sortOrder, String isParent, String createdUser, String createdTime, String modifiedUser, String modifiedTime) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.status = status;
        this.sortOrder = sortOrder;
        this.isParent = isParent;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsCategory)) return false;
        GoodsCategory that = (GoodsCategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(status, that.status) &&
                Objects.equals(sortOrder, that.sortOrder) &&
                Objects.equals(isParent, that.isParent) &&
                Objects.equals(createdUser, that.createdUser) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(modifiedUser, that.modifiedUser) &&
                Objects.equals(modifiedTime, that.modifiedTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, parentId, name, status, sortOrder, isParent, createdUser, createdTime, modifiedUser, modifiedTime);
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", isParent='" + isParent + '\'' +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
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
