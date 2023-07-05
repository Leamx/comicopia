package dev.matrixlab.comicopia.entity.comic;

import lombok.Data;

@Data
public class ImageDO {

    private Long id;

    private Long comicId;

    private Long chapterId;

    private Integer imageNum;

    // 0: normal 1: chatper cover 2: comic cover
    private Integer type;

}
