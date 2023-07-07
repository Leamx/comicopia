package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dao.mapper.comic.ComicMapper;
import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.entity.comic.ComicDO;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComicService {

    private final ComicMapper comicMapper;

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

    public void deleteComicById(Long comicId) {
        if (comicMapper.deleteComicById(comicId) == 0) {
            throw new InternalException("Delete failed.");
        }
        CallbackData.setResource("Deleted successfully.");
    }

    public void updateComicById(ComicDTO comicDTO) {
        if (comicMapper.checkComicExist(comicDTO.getId()) == 0) {
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

    public List<ComicDTO> getComicListByName(String comicName) {
        return comicMapper.getComicListByName(comicName);
    }

}
