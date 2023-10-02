package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.ComicDO;
import dev.matrixlab.comicopia.vo.comic.ComicDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ComicVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComicMapper {

    int insertComic(ComicDO comicDO);

    int deleteComicById(@Param("id") long id);

    int updateComicById(ComicDO comicDO);

    /**
     * 漫画浏览量加 1
     * @param id 漫画 id
     */
    void updateViewsById(@Param("id") long id);

    /**
     * 漫画浏览量加 1
     * @param chapterId 章节 id
     */
    void updateViewsByChapterId(@Param("chapterId") long chapterId);

    List<ComicVO> selectComics();

    List<ComicVO> selectComicsByName(@Param("comicName") String comicName);

    int countComicsByName(@Param("comicName") String comicName);

    int countComicsById(@Param("id") long id);

    ComicDetailsVO selectComicDetailsById(@Param("id") long id);

    List<ComicVO> selectComicsByAuthorName(String authorName);

    List<ComicVO> selectComicsByCategoryName(String categoryName);

    // 更新修改时间
    int updateComicModifiedTimeById(@Param("id") long id, @Param("modifiedTime") long modifiedTime);
}
