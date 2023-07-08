package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.ChapterInfoDTO;

import java.util.List;

public interface ChapterService {

    void createChapter(ChapterInfoDTO chapterInfoDTO);

    void deleteChapterById(Long chapterId);

    void updateChapterInfoById(ChapterInfoDTO chapterInfoDTO);

    List<ChapterInfoDTO> listChaptersByComicId(Long comicId);
}
