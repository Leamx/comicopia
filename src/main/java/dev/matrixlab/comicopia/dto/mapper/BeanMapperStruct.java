package dev.matrixlab.comicopia.dto.mapper;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.entity.comic.ComicDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BeanMapperStruct {

    BeanMapperStruct BEAN_MAPPER_STRUCT = Mappers.getMapper(BeanMapperStruct.class);

    // -------------------------- comic -------------------------------------

    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "publishTime", target = "publishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    ComicDO comicDTO2ComicDO(ComicDTO comicDTO);

    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "publishTime", target = "publishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    ComicDTO comicDO2ComicDTO(ComicDO comicDO);

}
