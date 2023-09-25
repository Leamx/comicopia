package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comic")
@RequiredArgsConstructor
public class ComicController {

    private final ComicService comicService;

    @PostMapping("/createComic")
    public CallbackData createComic(@RequestBody ComicDTO comicDTO) {
        return CallbackData.build(true, () -> {
            comicService.createComic(comicDTO);
        });
    }

    @DeleteMapping("/deleteComicById")
    public CallbackData deleteComicById(@RequestParam("comicId") Long comicId) {
        return CallbackData.build(true, () -> {
           comicService.deleteComicById(comicId);
        });
    }

    @PutMapping("/updateComicById")
    public CallbackData updateComicById(@RequestBody ComicDTO comicDTO) {
        return CallbackData.build(true, () -> {
            comicService.updateComicById(comicDTO);
        });
    }

    @GetMapping("/getComicListByName")
    public CallbackData getComicListByName(@RequestParam(value = "comicName", required = false, defaultValue = "") String comicName) {
        return CallbackData.build(true, comicService.listComicsByName(comicName));
    }

}
