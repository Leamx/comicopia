package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.AuthorMapper;
import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import dev.matrixlab.comicopia.service.comic.AuthorService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;

    @Override
    public void createAuthor(AuthorDTO authorDTO) {
        if (authorMapper.nameDuplicateCheck(authorDTO.getName()) > 0) {
            throw new InternalException("The author name is duplicated, creating a author failed.");
        }
        AuthorDO authorDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.authorDTO2AuthorDO(authorDTO);
        Long now = System.currentTimeMillis();
        authorDO.setGmtCreate(now);
        authorDO.setGmtModified(now);
        if (authorMapper.insertAuthor(authorDO) == 0) {
            throw new InternalException("Save failed.");
        }
        CallbackData.setResource("Added successfully.");
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        if (authorMapper.deleteAuthorById(authorId) == 0) {
            throw new InternalException("Delete failed.");
        }
        CallbackData.setResource("Deleted successfully.");
    }

    @Override
    public void updateAuthorById(AuthorDTO authorDTO) {
        if (authorMapper.checkAuthorExistById(authorDTO.getId()) == 0) {
            throw new InternalException("Author does not exist.");
        }
        AuthorDO authorDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.authorDTO2AuthorDO(authorDTO);
        Long now = System.currentTimeMillis();
        authorDO.setGmtModified(now);
        if (authorMapper.updateAuthorById(authorDO) == 0) {
            throw new InternalException("Update failed.");
        }
        CallbackData.setResource("Updated successfully.");
    }

    @Override
    public List<AuthorDTO> listAuthorsByName(String authorName) {
        if ("".equals(authorName)) {
            return authorMapper.listAuthors();
        } else {
            return authorMapper.listAuthorsByName(authorName);
        }
    }

}
