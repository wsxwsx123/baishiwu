package com.cdvtc.contact.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contact {
    private int id;
    private String name;
    private String stuid;
    private String sex;
    private String mobile;
    private String email;
    private String qq;
    private ClassInfo classInfo;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "stuid")
    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                Objects.equals(name, contact.name) &&
                Objects.equals(stuid, contact.stuid) &&
                Objects.equals(sex, contact.sex) &&
                Objects.equals(mobile, contact.mobile) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(qq, contact.qq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stuid, sex, mobile, email, qq);
    }

    @ManyToOne
    @JoinColumn(name = "classId", referencedColumnName = "id")
    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
}
