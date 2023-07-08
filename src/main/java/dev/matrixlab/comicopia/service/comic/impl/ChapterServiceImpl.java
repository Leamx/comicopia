package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.ChapterMapper;
import dev.matrixlab.comicopia.dto.comic.ChapterInfoDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.entity.comic.ChapterDO;
import dev.matrixlab.comicopia.service.comic.ChapterService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterMapper chapterMapper;

    @Override
    public void createChapter(ChapterInfoDTO chapterInfoDTO) {
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
        CallbackData.setResource("Added successfully.");
    }

    @Override
    public void deleteChapterById(Long chapterId) {
        if (chapterMapper.deleteChapterById(chapterId) == 0) {
            throw new InternalException("Delete failed.");
        }
        CallbackData.setResource("Deleted successfully.");
    }

    @Override
    public void updateChapterInfoById(ChapterInfoDTO chapterInfoDTO) {
        if (chapterMapper.checkChapterExistByChapterId(chapterInfoDTO.getId()) > 0) {
            throw new InternalException("The chapter order is duplicated, creating a chapter failed.");
        }
        ChapterDO chapterDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.chatperInfoDTO2ChapterDO(chapterInfoDTO);
        Long now = System.currentTimeMillis();
        chapterDO.setGmtModified(now);
        if (chapterMapper.updateChapterById(chapterDO) == 0) {
            throw new InternalException("Update failed.");
        }
        CallbackData.setResource("Updated successfully.");
    }

    @Override
    public List<ChapterInfoDTO> listChaptersByComicId(Long comicId) {
        return chapterMapper.listChaptersByComicId(comicId);
    }
}
