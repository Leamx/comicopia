package dev.matrixlab.comicopia.vo.comic;

import java.io.Serializable;
import java.util.List;

public class ComicDetailsVO implements Serializable {

    private static final long serialVersionUID = -2542552549431021163L;

    private Long id;

    private String name;

    private String description;

    private String coverUrl;

    private Integer status; // 0: loading 1: finished

    private Long views;

    private Long likes;

    private Long gmtCreate;

    private List<AuthorVO> authors;

    private List<ChapterVO> chapters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public List<AuthorVO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorVO> authors) {
        this.authors = authors;
    }

    public List<ChapterVO> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterVO> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "ComicDetailsVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", status=" + status +
                ", views=" + views +
                ", likes=" + likes +
                ", gmtCreate=" + gmtCreate +
                ", authors=" + authors +
                ", chapters=" + chapters +
                '}';
    }
}
