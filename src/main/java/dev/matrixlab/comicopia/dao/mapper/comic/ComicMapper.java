package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.ComicDO;
import dev.matrixlab.comicopia.vo.comic.ComicVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComicMapper {

    int insertComic(ComicDO comicDO);

    int deleteComicById(@Param("id") Long id);

    int updateComicById(ComicDO comicDO);

    List<ComicVO> listComics();

    List<ComicVO> listComicsByName(@Param("comicName") String comicName);

    int nameDuplicateCheck(@Param("comicName") String comicName);

    int checkComicExistById(@Param("id") Long id);
}
