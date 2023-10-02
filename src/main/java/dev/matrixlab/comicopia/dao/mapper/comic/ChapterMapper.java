package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.ChapterDO;
import dev.matrixlab.comicopia.vo.comic.ChapterDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ChapterVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChapterMapper {

    int countChapterByComicId(@Param("comicId") long comicId);

    int insertChapter(ChapterDO chapterDO);

    int deleteChapterById(@Param("id") long id);

    /**
     * 通过 id 查询章节数量，用于判断章节是否存在
     * @param id chapter id
     * @return 章节数量
     */
    int countChaptersById(@Param("id") long id);

    int updateChapterById(ChapterDO chapterDO);

    List<ChapterVO> selectChaptersByComicId(@Param("comicId") long comicId);

    ChapterDetailsVO selectChapterDetailsById(@Param("id") long id);

    ChapterDO selectChapterById(@Param("chapterId") long chapterId);

}
