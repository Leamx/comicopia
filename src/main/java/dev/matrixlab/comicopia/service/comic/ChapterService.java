package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.ChapterInfoDTO;
import dev.matrixlab.comicopia.vo.comic.ChapterInfoVO;

import java.util.List;

public interface ChapterService {

    String saveChapter(ChapterInfoDTO chapterInfoDTO);

    String removeChapterById(Long chapterId);

    String updateChapterInfoById(ChapterInfoDTO chapterInfoDTO);

    List<ChapterInfoVO> listChaptersByComicId(Long comicId);
}
