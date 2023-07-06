package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.dto.system.CallbackDataDTO;
import dev.matrixlab.comicopia.service.comic.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comic")
@RequiredArgsConstructor
public class ComicController {

    private final ComicService comicService;

    @PostMapping("/createComic")
    private CallbackDataDTO createComic(@RequestBody ComicDTO comicDTO) {
        return CallbackDataDTO.build(true, () -> {
            comicService.createComic(comicDTO);
        });
    }

    @PostMapping("/deleteComicById")
    private CallbackDataDTO deleteComicById(@RequestBody ComicDTO comicDTO) {
        return CallbackDataDTO.build(true, () -> {
           comicService.deleteComicById(comicDTO);
        });
    }

    @GetMapping("/getComicListByName")
    private CallbackDataDTO getComicListByName(@RequestParam("name") String name) {
        return CallbackDataDTO.build(true, comicService.getComicListByName(name));
    }

}
