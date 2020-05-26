package com.cdvtc.contact.data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "tb_user", schema = "pepsi", catalog = "")
public class TbUser {
    private int id;
    private String userName;
    private int userId;
    private String password;
    private String passGuardIssueProblem;
    private String passGuardIssue;
    private int passPhone;
    private Integer passQq;
    private String faceUrl;
    private Time birthdate;
    private String sex;
    private String recommendCode;
    private String othersRecommendCode;
    private Integer fansNumber;
    private Boolean ifAssessor;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(int id) {
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
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "passGuardIssueProblem")
    public String getPassGuardIssueProblem() {
        return passGuardIssueProblem;
    }

    public void setPassGuardIssueProblem(String passGuardIssueProblem) {
        this.passGuardIssueProblem = passGuardIssueProblem;
    }

    @Basic
    @Column(name = "passGuardIssue")
    public String getPassGuardIssue() {
        return passGuardIssue;
    }

    public void setPassGuardIssue(String passGuardIssue) {
        this.passGuardIssue = passGuardIssue;
    }

    @Basic
    @Column(name = "passPhone")
    public int getPassPhone() {
        return passPhone;
    }

    public void setPassPhone(int passPhone) {
        this.passPhone = passPhone;
    }

    @Basic
    @Column(name = "passQq")
    public Integer getPassQq() {
        return passQq;
    }

    public void setPassQq(Integer passQq) {
        this.passQq = passQq;
    }

    @Basic
    @Column(name = "faceUrl")
    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    @Basic
    @Column(name = "Birthdate")
    public Time getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Time birthdate) {
        this.birthdate = birthdate;
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
    @Column(name = "recommendCode")
    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }

    @Basic
    @Column(name = "othersRecommendCode")
    public String getOthersRecommendCode() {
        return othersRecommendCode;
    }

    public void setOthersRecommendCode(String othersRecommendCode) {
        this.othersRecommendCode = othersRecommendCode;
    }

    @Basic
    @Column(name = "fansNumber")
    public Integer getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(Integer fansNumber) {
        this.fansNumber = fansNumber;
    }

    @Basic
    @Column(name = "ifAssessor")
    public Boolean getIfAssessor() {
        return ifAssessor;
    }

    public void setIfAssessor(Boolean ifAssessor) {
        this.ifAssessor = ifAssessor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUser tbUser = (TbUser) o;
        return id == tbUser.id &&
                userId == tbUser.userId &&
                Objects.equals(userName, tbUser.userName) &&
                Objects.equals(password, tbUser.password) &&
                Objects.equals(passGuardIssueProblem, tbUser.passGuardIssueProblem) &&
                Objects.equals(passGuardIssue, tbUser.passGuardIssue) &&
                Objects.equals(passPhone, tbUser.passPhone) &&
                Objects.equals(passQq, tbUser.passQq) &&
                Objects.equals(faceUrl, tbUser.faceUrl) &&
                Objects.equals(birthdate, tbUser.birthdate) &&
                Objects.equals(sex, tbUser.sex) &&
                Objects.equals(recommendCode, tbUser.recommendCode) &&
                Objects.equals(othersRecommendCode, tbUser.othersRecommendCode) &&
                Objects.equals(fansNumber, tbUser.fansNumber) &&
                Objects.equals(ifAssessor, tbUser.ifAssessor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userId, password, passGuardIssueProblem, passGuardIssue, passPhone, passQq, faceUrl, birthdate, sex, recommendCode, othersRecommendCode, fansNumber, ifAssessor);
    }

    public void setAccount(int account) {
    }
}
