package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dao.mapper.comic.ComicMapper;
import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.dto.mapper.BeanMapperStruct;
import dev.matrixlab.comicopia.dto.system.CallbackDataDTO;
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
        ComicDO comicDO = BeanMapperStruct.BEAN_MAPPER_STRUCT.comicDTO2ComicDO(comicDTO);
        // TODO 时间设置
        if (comicMapper.nameDuplicateCheck(comicDO.getName()) > 0) {
            throw new InternalException("漫画名称重复，创建漫画失败");
        }
        if (comicMapper.insert(comicDO) == 0) {
            throw new InternalException("保存失败");
        }
        CallbackDataDTO.setResource("添加成功");
    }

    public void deleteComicById(ComicDTO comicDTO) {

    }

    public List<ComicDTO> getComicListByName(String name) {
        return comicMapper.getComicListByName(name);
    }

}
