package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.dto.system.CallbackDataDTO;
import dev.matrixlab.comicopia.service.comic.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comic")
@RequiredArgsConstructor
public class ComicController {

    private final ComicService comicService;

    private CallbackDataDTO createComic(@RequestBody ComicDTO comicDTO) {
        return CallbackDataDTO.build(true, null);
    }

}
