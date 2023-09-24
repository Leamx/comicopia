package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import dev.matrixlab.comicopia.vo.comic.AuthorVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorMapper {

    int insertAuthor(AuthorDO authorDO);

    int deleteAuthorById(@Param("id") Long id);

    int nameDuplicateCheck(@Param("authorName") String authorName);

    int checkAuthorExistById(@Param("id") Integer id);

    int updateAuthorById(AuthorDO authorDO);

    List<AuthorVO> listAuthors();

    List<AuthorVO> listAuthorsByName(@Param("authorName") String authorName);
}
