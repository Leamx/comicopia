package dev.matrixlab.comicopia.dao.mapper.storage;

import dev.matrixlab.comicopia.entity.storage.ImageDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {

    int insertImage(ImageDO imageDO);

    int deleteImageByFileUID(String fileUID);

}
