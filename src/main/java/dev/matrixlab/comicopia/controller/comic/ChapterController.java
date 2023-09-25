package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.ChapterInfoDTO;
import dev.matrixlab.comicopia.entity.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.ChapterService;
import dev.matrixlab.comicopia.utils.CallbackUtils;
import dev.matrixlab.comicopia.vo.comic.ChapterVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(final ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @PostMapping("/addChapter")
    public CallbackData<String> addChapter(@RequestBody ChapterInfoDTO chapterInfoDTO) {
        return CallbackUtils.success(chapterService.saveChapter(chapterInfoDTO));
    }

    @DeleteMapping("/deleteChapterById")
    public CallbackData<String> deleteChapterById(@RequestParam("chapterId") Long chapterId) {
        return CallbackUtils.success(chapterService.removeChapterById(chapterId));
    }

    @PutMapping("/modifyChapterById")
    public CallbackData<String> modifyChapterById(@RequestBody ChapterInfoDTO chapterInfoDTO) {
        return CallbackUtils.success(chapterService.updateChapterInfoById(chapterInfoDTO));
    }

    @GetMapping("/queryChaptersByComicId")
    public CallbackData<List<ChapterVO>> getChaptersByComicId(@RequestParam("comicId") Long comicId) {
        return CallbackUtils.success(chapterService.listChaptersByComicId(comicId));
    }

}
