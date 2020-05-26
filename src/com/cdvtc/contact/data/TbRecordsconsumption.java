package com.cdvtc.contact.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_recordsconsumption", schema = "pepsi", catalog = "")
public class TbRecordsconsumption {
    private long id;
    private Long commentsId;
    private Double money;
    private Long userId;

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
    public Long getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Long commentsId) {
        this.commentsId = commentsId;
    }

    @Basic
    @Column(name = "Money")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Basic
    @Column(name = "userId")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbRecordsconsumption that = (TbRecordsconsumption) o;
        return id == that.id &&
                Objects.equals(commentsId, that.commentsId) &&
                Objects.equals(money, that.money) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentsId, money, userId);
    }
}
