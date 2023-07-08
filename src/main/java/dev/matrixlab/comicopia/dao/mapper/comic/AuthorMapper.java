package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorMapper {

    int insertAuthor(AuthorDO authorDO);

    int deleteAuthorById(@Param("authorId") Long authorId);

    int nameDuplicateCheck(String authorName);

    int checkAuthorExistById(@Param("authorId") Integer authorId);

    int updateAuthorById(AuthorDO authorDO);

    List<AuthorDTO> listAuthors();

    List<AuthorDTO> listAuthorsByName(@Param("authorName") String authorName);
}
