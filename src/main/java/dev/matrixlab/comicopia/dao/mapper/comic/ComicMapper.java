package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.entity.comic.ComicDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComicMapper {

    Integer insertComic(ComicDO comicDO);

    Integer deleteComicById(@Param("comicId") Long comicId);

    Integer updateComicById(ComicDO comicDO);

    List<ComicDTO> getComicList();

    List<ComicDTO> getComicListByName(@Param("comicName") String comicName);

    Integer nameDuplicateCheck(@Param("comicName") String comicName);

    Integer checkComicExistById(@Param("comicId") Long comicId);
}
