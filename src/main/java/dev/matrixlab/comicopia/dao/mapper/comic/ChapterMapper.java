package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.ChapterDO;
import dev.matrixlab.comicopia.vo.comic.ChapterInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChapterMapper {

    int countChapterByChapterOrder(@Param("comicId") Long comicId, @Param("chapterOrder") Integer chapterOrder);

    int insertChapter(ChapterDO chapterDO);

    int deleteChapterById(@Param("id") Long id);

    int countChaptersById(@Param("id") Long id);

    int updateChapterById(ChapterDO chapterDO);

    List<ChapterInfoVO> selectChaptersByComicId(@Param("comicId") Long comicId);
}
