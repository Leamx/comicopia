package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.ChapterMapper;
import dev.matrixlab.comicopia.dto.comic.ChapterDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.entity.comic.ChapterDO;
import dev.matrixlab.comicopia.service.comic.ChapterService;
import dev.matrixlab.comicopia.vo.comic.ChapterDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ChapterVO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterMapper chapterMapper;

    public ChapterServiceImpl(final ChapterMapper chapterMapper) {
        this.chapterMapper = chapterMapper;
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
    public String removeChapterById(Long chapterId) {
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
    public List<ChapterVO> listChaptersByComicId(Long comicId) {
        return chapterMapper.selectChaptersByComicId(comicId);
    }

    @Override
    public ChapterDetailsVO getChapterDetailsById(Long chapterId) {
        return chapterMapper.selectChapterDetailsById(chapterId);
    }

}
