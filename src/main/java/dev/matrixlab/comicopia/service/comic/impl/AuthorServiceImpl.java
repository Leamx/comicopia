package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.AuthorMapper;
import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import dev.matrixlab.comicopia.service.comic.AuthorService;
import dev.matrixlab.comicopia.vo.comic.AuthorVO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;

    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

    public AuthorServiceImpl(final AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    @Override
    public String saveAuthor(AuthorDTO authorDTO) {
        if (authorMapper.countAuthorsByName(authorDTO.getName()) > 0) {
            throw new InternalException("The author name is duplicated, creating a author failed.");
        }
        AuthorDO authorDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.authorDTO2AuthorDO(authorDTO);
        Long now = System.currentTimeMillis();
        authorDO.setGmtCreate(now);
        authorDO.setGmtModified(now);
        if (authorMapper.insertAuthor(authorDO) == 0) {
            throw new InternalException("Save failed.");
        }
        return "Added author successfully.";
    }

    @Override
    public String removeAuthorById(Long authorId) {
        if (authorMapper.deleteAuthorById(authorId) == 0) {
            throw new InternalException("Delete failed.");
        }
        return "Removed author successfully.";
    }

    @Override
    public String updateAuthorById(AuthorDTO authorDTO) {
        if (authorMapper.countAuthorsById(authorDTO.getId()) == 0) {
            throw new InternalException("Author does not exist.");
        }
        AuthorDO authorDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.authorDTO2AuthorDO(authorDTO);
        Long now = System.currentTimeMillis();
        authorDO.setGmtModified(now);
        if (authorMapper.updateAuthorById(authorDO) == 0) {
            throw new InternalException("Update failed.");
        }
        return "Updated author successfully.";
    }

    @Override
    public List<AuthorVO> listAuthorsByName(String authorName) {
        if ("".equals(authorName)) {
            return authorMapper.selectAuthors();
        } else {
            return authorMapper.selectAuthorsByName(authorName);
        }
    }

}
