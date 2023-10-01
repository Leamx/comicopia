package dev.matrixlab.comicopia.vo.comic;

import dev.matrixlab.comicopia.vo.storage.ImageVO;

import java.io.Serializable;
import java.util.List;

public class ChapterDetailsVO implements Serializable {
    private static final long serialVersionUID = -7577348408220687058L;

    private Long id;

    private Long comicId;

    private String title;

    private String subTitle;

    private Integer order;

    private Long gmtCreate;

    private List<ImageVO> images;

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

    public List<ImageVO> getImages() {
        return images;
    }

    public void setImages(List<ImageVO> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ChapterDetailsVO{" +
                "id=" + id +
                ", comicId=" + comicId +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", order=" + order +
                ", gmtCreate=" + gmtCreate +
                ", images=" + images +
                '}';
    }
}
