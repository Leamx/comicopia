package dev.matrixlab.comicopia.service.storage.impl;

import dev.matrixlab.comicopia.dao.mapper.storage.ImageMapper;
import dev.matrixlab.comicopia.entity.storage.ImageDO;
import dev.matrixlab.comicopia.service.storage.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageMapper imageMapper;

    public ImageServiceImpl(final ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public String saveImage(ImageDO imageDO) {
        return null;
    }
}
