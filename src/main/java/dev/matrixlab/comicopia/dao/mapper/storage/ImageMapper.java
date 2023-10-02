package dev.matrixlab.comicopia.dao.mapper.storage;

import dev.matrixlab.comicopia.entity.storage.ImageDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ImageMapper {

    int insertImage(ImageDO imageDO);

    int deleteImageByFileUID(@Param("fileUID") String fileUID);

    int deleteImagesByChapterId(@Param("chapterId") long chapterId);

    String selectImageURIByFileUID(@Param("fileUID") String fileUID);

}
