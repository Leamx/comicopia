package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.ChapterDTO;
import dev.matrixlab.comicopia.vo.comic.ChapterDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ChapterVO;

import java.util.List;

public interface ChapterService {

    String saveChapter(ChapterDTO chapterDTO);

    String removeChapterById(long chapterId);

    String updateChapterById(ChapterDTO chapterDTO);

    List<ChapterVO> listChaptersByComicId(long comicId);

    ChapterDetailsVO getChapterDetailsById(long chapterId);
}
