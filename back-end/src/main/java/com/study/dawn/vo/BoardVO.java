package com.study.dawn.vo;

import java.util.Date;

public class BoardVO {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private Date reg_tm;
    private Date upt_tm;
    private Date del_tm;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getReg_tm() {
        return reg_tm;
    }

    public void setReg_tm(Date reg_tm) {
        this.reg_tm = reg_tm;
    }

    public Date getUpt_tm() {
        return upt_tm;
    }

    public void setUpt_tm(Date upt_tm) {
        this.upt_tm = upt_tm;
    }

    public Date getDel_tm() {
        return del_tm;
    }

    public void setDel_tm(Date del_tm) {
        this.del_tm = del_tm;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", reg_tm=" + reg_tm +
                ", upt_tm=" + upt_tm +
                ", del_tm=" + del_tm +
                '}';
    }
}
