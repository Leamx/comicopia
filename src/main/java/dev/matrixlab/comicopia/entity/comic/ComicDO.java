package dev.matrixlab.comicopia.entity.comic;

import lombok.Data;

import java.util.Date;

@Data
public class ComicDO {

    private Long id;

    private String name;

    private String description;

    private String coverUrl;

    private Integer status; // 0: loading 1: finished

    private Long views;

    private Long likes;

    private Long gmtCreate;

    private Long gmtModified;

}
