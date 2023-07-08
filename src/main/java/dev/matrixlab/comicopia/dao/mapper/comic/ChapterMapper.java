package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.dto.comic.ChapterInfoDTO;
import dev.matrixlab.comicopia.entity.comic.ChapterDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChapterMapper {

    int checkChapterExistByComicIdAndChapterOrder(Long comicId, Integer chapterOrder);

    int insertChapter(ChapterDO chapterDO);

    int deleteChapterById(Long chapterId);

    int checkChapterExistByChapterId(Long id);

    int updateChapterById(ChapterDO chapterDO);

    List<ChapterInfoDTO> listChaptersByComicId(Long comicId);
}
