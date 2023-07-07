package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dao.mapper.comic.AuthorMapper;
import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorMapper authorMapper;
    
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

    public void deleteAuthorById(Long authorId) {
        if (authorMapper.deleteAuthorById(authorId) == 0) {
            throw new InternalException("Delete failed.");
        }
        CallbackData.setResource("Deleted successfully.");
    }

    public void updateAuthorById(AuthorDTO authorDTO) {
        if (authorMapper.checkAuthorExist(authorDTO.getId()) == 0) {
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

    public List<AuthorDTO> getAuthorListByName(String authorName) {
        return authorMapper.getAuthorListByName(authorName);
    }
}
