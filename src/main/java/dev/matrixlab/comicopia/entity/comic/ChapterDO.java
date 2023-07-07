package dev.matrixlab.comicopia.entity.comic;

import lombok.Data;

import java.util.Date;

@Data
public class ChapterDO {

    private Long id;

    private Long comicId;

    private String title;

    private String subTitle;

    private Integer chapterOrder;

    private Long gmtCreate;

    private Long gmtModified;

}
