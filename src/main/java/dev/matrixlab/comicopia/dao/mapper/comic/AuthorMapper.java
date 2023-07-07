package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {

    Integer insertAuthor(AuthorDO authorDO);

    Integer deleteAuthorById(Long authorId);

    Integer nameDuplicateCheck(String authorName);

    Integer checkAuthorExist(Integer id);

    int updateAuthorById(AuthorDO authorDO);

    List<AuthorDTO> getAuthorListByName(String authorName);
}
