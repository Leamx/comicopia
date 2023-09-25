package dev.matrixlab.comicopia.service.comic.impl;

import dev.matrixlab.comicopia.dao.mapper.comic.ComicMapper;
import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.entity.comic.ComicDO;
import dev.matrixlab.comicopia.service.comic.ComicService;
import dev.matrixlab.comicopia.vo.comic.ComicVO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {

    private final ComicMapper comicMapper;

    public ComicServiceImpl(final ComicMapper comicMapper) {
        this.comicMapper = comicMapper;
    }

    @Override
    public String saveComic(ComicDTO comicDTO) {
        if (comicMapper.countComicsByName(comicDTO.getName()) > 0) {
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
        return "Added comic successfully.";
    }

    @Override
    public String removeComicById(Long comicId) {
        if (comicMapper.deleteComicById(comicId) == 0) {
            throw new InternalException("Delete failed.");
        }
        return "Deleted comic successfully.";
    }

    @Override
    public String updateComicById(ComicDTO comicDTO) {
        if (comicMapper.countComicsById(comicDTO.getId()) == 0) {
            throw new InternalException("Comic does not exist.");
        }
        ComicDO comicDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.comicDTO2ComicDO(comicDTO);
        Long now = System.currentTimeMillis();
        comicDO.setGmtModified(now);
        if (comicMapper.updateComicById(comicDO) == 0) {
            throw new InternalException("Update failed.");
        }
        return "Updated comic successfully.";
    }

    @Override
    public List<ComicVO> listComicsByName(String comicName) {
        if ("".equals(comicName)) {
            return comicMapper.selectComics();
        } else {
            return comicMapper.selectComicsByName(comicName);
        }
    }

}
