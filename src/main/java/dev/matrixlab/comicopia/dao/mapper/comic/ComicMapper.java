package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.ComicDO;
import dev.matrixlab.comicopia.vo.comic.ComicVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComicMapper {

    int insertComic(ComicDO comicDO);

    int deleteComicById(@Param("id") long id);

    int updateComicById(ComicDO comicDO);

    List<ComicVO> selectComics();

    List<ComicVO> selectComicsByName(@Param("comicName") String comicName);

    int countComicsByName(@Param("comicName") String comicName);

    int countComicsById(@Param("id") long id);
}
