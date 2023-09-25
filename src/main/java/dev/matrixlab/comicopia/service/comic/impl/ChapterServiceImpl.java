package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.ChapterMapper;
import dev.matrixlab.comicopia.dto.comic.ChapterInfoDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.entity.comic.ChapterDO;
import dev.matrixlab.comicopia.service.comic.ChapterService;
import dev.matrixlab.comicopia.vo.comic.ChapterInfoVO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterMapper chapterMapper;

    public ChapterServiceImpl(final ChapterMapper chapterMapper) {
        this.chapterMapper = chapterMapper;
    }

    @Override
    public String saveChapter(ChapterInfoDTO chapterInfoDTO) {
        if (chapterMapper.checkChapterExistByComicIdAndChapterOrder(chapterInfoDTO.getComicId(), chapterInfoDTO.getChapterOrder()) > 0) {
            throw new InternalException("The chapter order is duplicated, creating a chapter failed.");
        }
        ChapterDO chapterDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.chatperInfoDTO2ChapterDO(chapterInfoDTO);
        Long now = System.currentTimeMillis();
        chapterDO.setGmtCreate(now);
        chapterDO.setGmtModified(now);
        if (chapterMapper.insertChapter(chapterDO) == 0) {
            throw new InternalException("Save failed.");
        }
        return "Added chapter successfully.";
    }

    @Override
    public String removeChapterById(Long chapterId) {
        if (chapterMapper.deleteChapterById(chapterId) == 0) {
            throw new InternalException("Delete failed.");
        }
        return "Deleted chapter successfully.";
    }

    @Override
    public String updateChapterInfoById(ChapterInfoDTO chapterInfoDTO) {
        if (chapterMapper.checkChapterExistById(chapterInfoDTO.getId()) > 0) {
            throw new InternalException("The chapter order is duplicated, creating a chapter failed.");
        }
        ChapterDO chapterDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.chatperInfoDTO2ChapterDO(chapterInfoDTO);
        Long now = System.currentTimeMillis();
        chapterDO.setGmtModified(now);
        if (chapterMapper.updateChapterById(chapterDO) == 0) {
            throw new InternalException("Update failed.");
        }
        return "Updated chapter successfully.";
    }

    @Override
    public List<ChapterInfoVO> listChaptersByComicId(Long comicId) {
        return chapterMapper.listChaptersByComicId(comicId);
    }
}
