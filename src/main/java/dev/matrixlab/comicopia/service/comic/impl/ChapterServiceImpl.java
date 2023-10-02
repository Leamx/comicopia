package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.constant.Constants;
import dev.matrixlab.comicopia.controller.exception.SqlExecuteErrorException;
import dev.matrixlab.comicopia.dao.mapper.comic.ChapterMapper;
import dev.matrixlab.comicopia.dao.mapper.comic.ComicMapper;
import dev.matrixlab.comicopia.dao.mapper.storage.ImageMapper;
import dev.matrixlab.comicopia.dto.comic.ChapterDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.entity.comic.ChapterDO;
import dev.matrixlab.comicopia.entity.storage.ImageDO;
import dev.matrixlab.comicopia.service.comic.ChapterService;
import dev.matrixlab.comicopia.service.storage.FileStorageService;
import dev.matrixlab.comicopia.vo.comic.ChapterDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ChapterVO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterMapper chapterMapper;

    private final ComicMapper comicMapper;

    private final FileStorageService fileStorageService;

    private final SqlSessionFactory sqlSessionFactory;

    public ChapterServiceImpl(final ChapterMapper chapterMapper,
                              final ComicMapper comicMapper,
                              final FileStorageService fileStorageService,
                              final SqlSessionFactory sqlSessionFactory) {
        this.chapterMapper = chapterMapper;
        this.comicMapper = comicMapper;
        this.fileStorageService = fileStorageService;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Override
    public String saveChapter(ChapterDTO chapterDTO) {
        int count = chapterMapper.countChapterByComicId(chapterDTO.getComicId());
        ChapterDO chapterDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.chatperDTO2ChapterDO(chapterDTO);
        Long now = System.currentTimeMillis();
        chapterDO.setOrder(++count);
        chapterDO.setGmtCreate(now);
        chapterDO.setGmtModified(now);
        if (chapterMapper.insertChapter(chapterDO) == 0) {
            throw new InternalException("Save failed.");
        }
        return "Added chapter successfully.";
    }

    @Override
    public String removeChapterById(long chapterId) {
        if (chapterMapper.deleteChapterById(chapterId) == 0) {
            throw new InternalException("Delete failed.");
        }
        return "Deleted chapter successfully.";
    }

    @Override
    public String updateChapterById(ChapterDTO chapterDTO) {
        if (chapterMapper.countChaptersById(chapterDTO.getId()) == 0) {
            throw new InternalException("The chapter does not exist.");
        }
        ChapterDO chapterDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.chatperDTO2ChapterDO(chapterDTO);
        Long now = System.currentTimeMillis();
        chapterDO.setGmtModified(now);
        if (chapterMapper.updateChapterById(chapterDO) == 0) {
            throw new InternalException("Update failed.");
        }
        return "Updated chapter successfully.";
    }

    @Override
    public List<ChapterVO> listChaptersByComicId(long comicId) {
        return chapterMapper.selectChaptersByComicId(comicId);
    }

    @Override
    public ChapterDetailsVO getChapterDetailsById(long chapterId) {
        return chapterMapper.selectChapterDetailsById(chapterId);
    }

    @Override
    @Transactional
    public String saveChapterImagesById(long chapterId, List<MultipartFile> files) {
        // 获取当前章节实体
        ChapterDO chapterDO = chapterMapper.selectChapterById(chapterId);
        if (chapterDO == null) {
            throw new InternalException("章节不存在");
        }

        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
            long now = System.currentTimeMillis();

            ImageMapper imageMapper = sqlSession.getMapper(ImageMapper.class);
            // 先删除该章节之前的图片
            imageMapper.deleteImagesByChapterId(chapterId);
            // 记录图片顺序
            int sort = 0;
            for (MultipartFile file : files) {
                String md5Hex = DigestUtils.md5Hex(file.getInputStream());
                String uri = fileStorageService.storeFile(file, md5Hex, Constants.IMAGE_TYPE_CHAPTER_CONTAIN);

                ImageDO imageDO = new ImageDO();
                imageDO.setFileUID(md5Hex);
                imageDO.setComicId(chapterDO.getComicId());
                imageDO.setChapterId(chapterId);
                imageDO.setSort(++sort);
                imageDO.setType(Constants.IMAGE_TYPE_CHAPTER_CONTAIN);
                imageDO.setUri(uri);
                imageDO.setOriginalName(file.getOriginalFilename());
                imageDO.setExtension(FilenameUtils.getExtension(file.getOriginalFilename()));
                imageDO.setGmtCreate(now);
                imageDO.setGmtModified(now);
                // 保存图片
                if (imageMapper.insertImage(imageDO) == 0) {
                    throw new SqlExecuteErrorException("保存章节图片异常");
                }
            }
            if (comicMapper.updateComicModifiedTimeById(chapterDO.getComicId(), now) == 0) {
                throw new SqlExecuteErrorException("更新漫画修改时间异常");
            }
            sqlSession.commit();
        } catch (IOException e) {
            throw new InternalException("拷贝文件异常");
        }
        return "添加章节图片成功";
    }
}
