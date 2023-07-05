package dev.matrixlab.comicopia.entity.comic;

import lombok.Data;

import java.util.Date;

@Data
public class ChapterDO {

    private Long id;

    private Long comicId;

    private String title;

    private String subTitle;

    private Integer chapterNum;

    private Date createTime;

    private Date updateTime;

    private Date publishTime;

}
