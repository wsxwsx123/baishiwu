package com.cdvtc.contact.data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "tb_answer", schema = "pepsi", catalog = "")
public class TbAnswer {
    private int id;
    private Long commentsId;
    private Long resourceId;
    private String answer;
    private Time answertime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "resourceId")
    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "answertime")
    public Time getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Time answertime) {
        this.answertime = answertime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAnswer tbAnswer = (TbAnswer) o;
        return id == tbAnswer.id &&
                Objects.equals(commentsId, tbAnswer.commentsId) &&
                Objects.equals(resourceId, tbAnswer.resourceId) &&
                Objects.equals(answer, tbAnswer.answer) &&
                Objects.equals(answertime, tbAnswer.answertime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentsId, resourceId, answer, answertime);
    }
}
