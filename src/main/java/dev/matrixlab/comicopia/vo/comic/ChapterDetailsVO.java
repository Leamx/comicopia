package dev.matrixlab.comicopia.vo.comic;

import java.io.Serializable;
import java.util.List;

public class ChapterDetailsVO implements Serializable {

    private static final long serialVersionUID = 6879562367975888213L;

    private ChapterVO chapterVO;

    private List<ImageVO> imageVOList;

    public ChapterVO getChapterVO() {
        return chapterVO;
    }

    public void setChapterVO(ChapterVO chapterVO) {
        this.chapterVO = chapterVO;
    }

    public List<ImageVO> getImageVOList() {
        return imageVOList;
    }

    public void setImageVOList(List<ImageVO> imageVOList) {
        this.imageVOList = imageVOList;
    }

    @Override
    public String toString() {
        return "ChapterDetailsVO{" +
                "chapterVO=" + chapterVO +
                ", imageVOList=" + imageVOList +
                '}';
    }
}
