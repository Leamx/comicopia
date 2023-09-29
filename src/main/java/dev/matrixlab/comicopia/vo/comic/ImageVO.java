package dev.matrixlab.comicopia.vo.comic;

import java.io.Serializable;

public class ImageVO implements Serializable {

    private static final long serialVersionUID = -2332812840691153125L;

    private String fileUID;

    private Long comicId;

    private Long chapterId;

    private Integer sort;

    private Integer type;

    private String uri;

    private Long gmtCreate;

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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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
                "fileUID='" + fileUID + '\'' +
                ", comicId=" + comicId +
                ", chapterId=" + chapterId +
                ", sort=" + sort +
                ", type=" + type +
                ", uri='" + uri + '\'' +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
