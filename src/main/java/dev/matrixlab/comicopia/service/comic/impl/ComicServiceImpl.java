package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.ComicMapper;
import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.entity.comic.ComicDO;
import dev.matrixlab.comicopia.service.comic.ComicService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComicServiceImpl implements ComicService {

    private final ComicMapper comicMapper;

    @Override
    public void createComic(ComicDTO comicDTO) {
        if (comicMapper.nameDuplicateCheck(comicDTO.getName()) > 0) {
            throw new InternalException("The comic name is duplicated, creating a comic failed.");
        }
        ComicDO comicDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.comicDTO2ComicDO(comicDTO);
        Long now = System.currentTimeMillis();
        comicDO.setStatus(0);
        comicDO.setViews(0L);
        comicDO.setLikes(0L);
        comicDO.setGmtCreate(now);
        comicDO.setGmtModified(now);
        if (comicMapper.insertComic(comicDO) == 0) {
            throw new InternalException("Save failed.");
        }
        CallbackData.setResource("Added successfully.");
    }

    @Override
    public void deleteComicById(Long comicId) {
        if (comicMapper.deleteComicById(comicId) == 0) {
            throw new InternalException("Delete failed.");
        }
        CallbackData.setResource("Deleted successfully.");
    }

    @Override
    public void updateComicById(ComicDTO comicDTO) {
        if (comicMapper.checkComicExistById(comicDTO.getId()) == 0) {
            throw new InternalException("Comic does not exist.");
        }
        ComicDO comicDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.comicDTO2ComicDO(comicDTO);
        Long now = System.currentTimeMillis();
        comicDO.setGmtModified(now);
        if (comicMapper.updateComicById(comicDO) == 0) {
            throw new InternalException("Update failed.");
        }
        CallbackData.setResource("Updated successfully.");
    }

    @Override
    public List<ComicDTO> listComicsByName(String comicName) {
        if ("".equals(comicName)) {
            return comicMapper.listComic();
        } else {
            return comicMapper.listComicsByName(comicName);
        }
    }

}
