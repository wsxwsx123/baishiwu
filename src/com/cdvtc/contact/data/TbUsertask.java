package com.cdvtc.contact.data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "tb_usertask", schema = "pepsi", catalog = "")
public class TbUsertask {
    private long id;
    private long commentsId;
    private long createUser;
    private Time createTime;
    private String updateUser;
    private Time updataTime;
    private Long praise;
    private Long step;
    private String comments;
    private Double money;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "commentsId")
    public long getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(long commentsId) {
        this.commentsId = commentsId;
    }

    @Basic
    @Column(name = "createUser")
    public long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(long createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "createTime")
    public Time getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateUser")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "updataTime")
    public Time getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(Time updataTime) {
        this.updataTime = updataTime;
    }

    @Basic
    @Column(name = "praise")
    public Long getPraise() {
        return praise;
    }

    public void setPraise(Long praise) {
        this.praise = praise;
    }

    @Basic
    @Column(name = "step")
    public Long getStep() {
        return step;
    }

    public void setStep(Long step) {
        this.step = step;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "money")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUsertask that = (TbUsertask) o;
        return id == that.id &&
                commentsId == that.commentsId &&
                createUser == that.createUser &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateUser, that.updateUser) &&
                Objects.equals(updataTime, that.updataTime) &&
                Objects.equals(praise, that.praise) &&
                Objects.equals(step, that.step) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentsId, createUser, createTime, updateUser, updataTime, praise, step, comments, money);
    }
}
