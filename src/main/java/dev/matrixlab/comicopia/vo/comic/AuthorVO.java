package dev.matrixlab.comicopia.vo.comic;

import java.io.Serializable;

public class AuthorVO implements Serializable {

    private static final long serialVersionUID = -6700343155005722263L;

    private Integer id;

    private String name;

    private String bio;

    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "AuthorVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
