package dev.matrixlab.comicopia.dto.comic;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChapterDataDTO implements Serializable {

    private static final long serialVersionUID = -2593142100176080512L;

    private ChapterInfoDTO chapterInfoDTO;

}
