package com.cdvtc.contact.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "tb_usershow", schema = "pepsi", catalog = "")
public class TbUsershow {
    private long id;
    private long showId;
    private long showUrlId;
    private String showContent;
    private Time showTime;
    private long showPraise;
    private boolean showSee;

    @Basic
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "showId")
    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    @Basic
    @Column(name = "showUrlId")
    public long getShowUrlId() {
        return showUrlId;
    }

    public void setShowUrlId(long showUrlId) {
        this.showUrlId = showUrlId;
    }

    @Basic
    @Column(name = "showContent")
    public String getShowContent() {
        return showContent;
    }

    public void setShowContent(String showContent) {
        this.showContent = showContent;
    }

    @Basic
    @Column(name = "showTime")
    public Time getShowTime() {
        return showTime;
    }

    public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }

    @Basic
    @Column(name = "showPraise")
    public long getShowPraise() {
        return showPraise;
    }

    public void setShowPraise(long showPraise) {
        this.showPraise = showPraise;
    }

    @Basic
    @Column(name = "showSee")
    public boolean isShowSee() {
        return showSee;
    }

    public void setShowSee(boolean showSee) {
        this.showSee = showSee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUsershow that = (TbUsershow) o;
        return id == that.id &&
                showId == that.showId &&
                showUrlId == that.showUrlId &&
                showPraise == that.showPraise &&
                showSee == that.showSee &&
                Objects.equals(showContent, that.showContent) &&
                Objects.equals(showTime, that.showTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, showId, showUrlId, showContent, showTime, showPraise, showSee);
    }
}
