package dev.matrixlab.comicopia.vo.comic;

import java.io.Serializable;

public class ChapterVO implements Serializable {

    private static final long serialVersionUID = -5265178301958953468L;

    private Long id;

    private Long comicId;

    private String title;

    private String subTitle;

    private Integer chapterOrder;

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

    public Integer getChapterOrder() {
        return chapterOrder;
    }

    public void setChapterOrder(Integer chapterOrder) {
        this.chapterOrder = chapterOrder;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "ChapterInfoVO{" +
                "id=" + id +
                ", comicId=" + comicId +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", chapterOrder=" + chapterOrder +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
