package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.entity.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.ComicService;
import dev.matrixlab.comicopia.utils.CallbackUtils;
import dev.matrixlab.comicopia.vo.comic.ComicVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comic")
public class ComicController {

    private final ComicService comicService;

    public ComicController(final ComicService comicService) {
        this.comicService = comicService;
    }

    @PostMapping("/addComic")
    public CallbackData<String> addComic(@RequestBody ComicDTO comicDTO) {
        return CallbackUtils.success(comicService.saveComic(comicDTO));
    }

    @DeleteMapping("/deleteComicById")
    public CallbackData<String> deleteComicById(@RequestParam("comicId") long comicId) {
        return CallbackUtils.success(comicService.removeComicById(comicId));
    }

    @PutMapping("/modifyComicById")
    public CallbackData<String> modifyComicById(@RequestBody ComicDTO comicDTO) {
        return CallbackUtils.success(comicService.updateComicById(comicDTO));
    }

    @GetMapping("/queryComicsByName")
    public CallbackData<List<ComicVO>> queryComicsByName(@RequestParam(value = "comicName", required = false, defaultValue = "") String comicName) {
        return CallbackUtils.success(comicService.listComicsByName(comicName));
    }

}
