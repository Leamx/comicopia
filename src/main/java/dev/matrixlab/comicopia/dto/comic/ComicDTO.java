package dev.matrixlab.comicopia.dto.comic;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ComicDTO implements Serializable {

    private static final long serialVersionUID = 1620184042446106784L;

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
