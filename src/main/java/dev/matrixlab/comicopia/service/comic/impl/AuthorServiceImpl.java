package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.constant.Constants;
import dev.matrixlab.comicopia.controller.exception.ColumnValueDuplicateException;
import dev.matrixlab.comicopia.dao.mapper.comic.AuthorMapper;
import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import dev.matrixlab.comicopia.service.comic.AuthorService;
import dev.matrixlab.comicopia.service.storage.FileStorageService;
import dev.matrixlab.comicopia.vo.comic.AuthorVO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;

    private final FileStorageService fileStorageService;

    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

    public AuthorServiceImpl(final AuthorMapper authorMapper, final FileStorageService fileStorageService) {
        this.authorMapper = authorMapper;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public String saveAuthor(AuthorDTO authorDTO) {
        if (authorMapper.countAuthorsByName(authorDTO.getName()) > 0) {
            throw new ColumnValueDuplicateException("The author name is duplicated, creating a author failed.");
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
    public String removeAuthorById(long authorId) {
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

    @Override
    @Transactional
    public String updateAvatarById(long authorId, MultipartFile file) {
        AuthorDO authorDO = authorMapper.selectAuthorById(authorId);
        if (authorDO == null) {
            throw new InternalException("Author does not exist.");
        }
        try {
            String md5Hex = DigestUtils.md5Hex(file.getInputStream());
            String uri = fileStorageService.storeFile(file, md5Hex, Constants.IMAGE_TYPE_AVATAR);
            authorDO.setAvatar(uri);
            Long now = System.currentTimeMillis();
            authorDO.setGmtModified(now);
            if (authorMapper.updateAuthorById(authorDO) == 0) {
                throw new InternalException("Update failed.");
            }
        } catch (IOException e) {
            throw new InternalException("Update failed.");
        }
        return "Updated avatar successfully.";
    }
}
