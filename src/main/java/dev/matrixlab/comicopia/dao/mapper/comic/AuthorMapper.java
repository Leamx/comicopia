package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorMapper {

    Integer insertAuthor(AuthorDO authorDO);

    Integer deleteAuthorById(@Param("authorId") Long authorId);

    Integer nameDuplicateCheck(String authorName);

    Integer checkAuthorExistById(@Param("authorId") Integer authorId);

    Integer updateAuthorById(AuthorDO authorDO);

    List<AuthorDTO> getAuthorList();

    List<AuthorDTO> getAuthorListByName(@Param("authorName") String authorName);
}
