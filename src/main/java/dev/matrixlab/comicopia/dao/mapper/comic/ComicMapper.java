package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.entity.comic.ComicDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComicMapper {

    int insertComic(ComicDO comicDO);

    int deleteComicById(@Param("comicId") Long comicId);

    int updateComicById(ComicDO comicDO);

    List<ComicDTO> listComic();

    List<ComicDTO> listComicsByName(@Param("comicName") String comicName);

    int nameDuplicateCheck(@Param("comicName") String comicName);

    int checkComicExistById(@Param("comicId") Long comicId);
}
