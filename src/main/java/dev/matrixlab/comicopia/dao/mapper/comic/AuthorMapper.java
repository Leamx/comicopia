package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import dev.matrixlab.comicopia.vo.comic.AuthorVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorMapper {

    int insertAuthor(AuthorDO authorDO);

    int deleteAuthorById(@Param("id") long id);

    int countAuthorsByName(@Param("authorName") String authorName);

    int countAuthorsById(@Param("id") long id);

    int updateAuthorById(AuthorDO authorDO);

    AuthorDO selectAuthorById(@Param("id") long id);

    List<AuthorVO> selectAuthors();

    List<AuthorVO> selectAuthorsByName(@Param("authorName") String authorName);
}
