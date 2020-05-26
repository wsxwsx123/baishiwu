package com.cdvtc.contact.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_administrator", schema = "pepsi", catalog = "")
public class TbAdministrator {
    private long id;
    private String userName;
    private long userId;
    private long passWord;
    private String idcard;
    private long phone;
    private String face;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "passWord")
    public long getPassWord() {
        return passWord;
    }

    public void setPassWord(long passWord) {
        this.passWord = passWord;
    }

    @Basic
    @Column(name = "idcard")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Basic
    @Column(name = "phone")
    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "face")
    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAdministrator that = (TbAdministrator) o;
        return id == that.id &&
                userId == that.userId &&
                passWord == that.passWord &&
                phone == that.phone &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(idcard, that.idcard) &&
                Objects.equals(face, that.face);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userId, passWord, idcard, phone, face);
    }
}
