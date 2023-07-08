package dev.matrixlab.comicopia.dto.comic;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChapterInfoDTO implements Serializable {

    private static final long serialVersionUID = 6965207432762767970L;

    private Long id;

    private Long comicId;

    private String title;

    private String subTitle;

    private Integer chapterOrder;

    private Long gmtCreate;

}
