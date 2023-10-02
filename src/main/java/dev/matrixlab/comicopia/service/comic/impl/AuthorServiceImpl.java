package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.constant.Constants;
import dev.matrixlab.comicopia.controller.exception.ColumnValueDuplicateException;
import dev.matrixlab.comicopia.dao.mapper.comic.AuthorMapper;
import dev.matrixlab.comicopia.dao.mapper.storage.ImageMapper;
import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import dev.matrixlab.comicopia.entity.storage.ImageDO;
import dev.matrixlab.comicopia.service.comic.AuthorService;
import dev.matrixlab.comicopia.service.storage.FileStorageService;
import dev.matrixlab.comicopia.vo.comic.AuthorVO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
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

    private final ImageMapper imageMapper;

    private final FileStorageService fileStorageService;

    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

    public AuthorServiceImpl(final AuthorMapper authorMapper,
                             final ImageMapper imageMapper,
                             final FileStorageService fileStorageService) {
        this.authorMapper = authorMapper;
        this.imageMapper = imageMapper;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public String saveAuthor(AuthorDTO authorDTO) {
        if (authorMapper.countAuthorsByName(authorDTO.getName()) > 0) {
            throw new ColumnValueDuplicateException("The author name is duplicated, creating a author failed.");
        }
        AuthorDO authorDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.authorDTO2AuthorDO(authorDTO);
        long now = System.currentTimeMillis();
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
        long now = System.currentTimeMillis();
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
            long now = System.currentTimeMillis();
            // 计算图片的 md5
            String md5Hex = DigestUtils.md5Hex(file.getInputStream());

            // 判断上传的图片数据库是否存在
            String uri = imageMapper.selectImageURIByFileUID(md5Hex);
            if (uri == null) {
                uri = fileStorageService.storeFile(file, md5Hex, Constants.IMAGE_TYPE_AVATAR);
                ImageDO imageDO = new ImageDO();
                imageDO.setFileUID(md5Hex);
                imageDO.setType(Constants.IMAGE_TYPE_AVATAR);
                imageDO.setUri(uri);
                imageDO.setOriginalName(file.getOriginalFilename());
                imageDO.setExtension(FilenameUtils.getExtension(file.getOriginalFilename()));
                imageDO.setDescription(String.format("Author avatar, authorName: %s", authorDO.getName()));
                imageDO.setGmtCreate(now);
                imageDO.setGmtModified(now);
                if (imageMapper.insertImage(imageDO) == 0) {
                    throw new InternalException("Add Image failed.");
                }
            }

            authorDO.setAvatar(uri);
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
