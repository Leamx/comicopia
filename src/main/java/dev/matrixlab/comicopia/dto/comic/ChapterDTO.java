package dev.matrixlab.comicopia.dto.comic;

import java.io.Serializable;

public class ChapterDTO implements Serializable {

    private static final long serialVersionUID = 6965207432762767970L;

    private Long id;

    private Long comicId;

    private String title;

    private String subTitle;

    private Integer order;

    private Long gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "ChapterDTO{" +
                "id=" + id +
                ", comicId=" + comicId +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", order=" + order +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
