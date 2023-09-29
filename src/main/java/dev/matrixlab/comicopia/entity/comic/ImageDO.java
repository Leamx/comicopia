package dev.matrixlab.comicopia.entity.comic;

public class ImageDO {

    private Long id;

    private String fileUID;

    private Long comicId;

    private Long chapterId;

    private Integer sort;

    // 0: normal 1: chatper cover 2: comic cover
    private Integer type;

    private String uri;

    private String originalName;

    private String description;

    private String extension;

    private Long gmtCreate;

    private Long gmtModified;

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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "ImageDO{" +
                "id=" + id +
                ", fileUID='" + fileUID + '\'' +
                ", comicId=" + comicId +
                ", chapterId=" + chapterId +
                ", sort=" + sort +
                ", type=" + type +
                ", uri='" + uri + '\'' +
                ", originalName='" + originalName + '\'' +
                ", description='" + description + '\'' +
                ", extension='" + extension + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
