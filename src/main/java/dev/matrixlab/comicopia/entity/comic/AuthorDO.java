package dev.matrixlab.comicopia.entity.comic;

import lombok.Data;

import java.util.Date;

@Data
public class AuthorDO {

    private Integer id;

    private String name;

    private String bio;

    private String avatar;

    private Date createTime;

    private Date updateTime;

}
