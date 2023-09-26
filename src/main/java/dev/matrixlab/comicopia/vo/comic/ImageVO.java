package dev.matrixlab.comicopia.vo.comic;

import java.io.Serializable;

public class ImageVO implements Serializable {

    private static final long serialVersionUID = -2332812840691153125L;

    private Long id;

    private String fileUID;

    private Long comicId;

    private Long chapterId;

    private Integer sort;

    private Integer type;

    private Long gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUID() {
        return fileUID;
    }

    public void setFileUID(String fileUID) {
        this.fileUID = fileUID;
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "ImageVO{" +
                "id=" + id +
                ", fileUID='" + fileUID + '\'' +
                ", comicId=" + comicId +
                ", chapterId=" + chapterId +
                ", sort=" + sort +
                ", type=" + type +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
