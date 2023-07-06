package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.entity.comic.ComicDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComicMapper {

    Integer insert(ComicDO comicDO);

    List<ComicDTO> getComicListByName(@Param("name") String name);

    Integer nameDuplicateCheck(@Param("name") String name);

}
