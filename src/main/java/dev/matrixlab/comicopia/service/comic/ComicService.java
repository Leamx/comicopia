package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.dto.system.CallbackDataDTO;
import org.springframework.stereotype.Service;

@Service
public class ComicService {

    public void createComic(ComicDTO comicDTO) {

        CallbackDataDTO.setResource("添加成功！");
        return ;
    }

}
