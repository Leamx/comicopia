package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.ChapterInfoDTO;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;

    @PostMapping("/createChapter")
    public CallbackData createChapter(@RequestBody ChapterInfoDTO chapterInfoDTO) {
        return CallbackData.build(true, () -> {
            chapterService.createChapter(chapterInfoDTO);
        });
    }

    @DeleteMapping("/deleteChapterById")
    public CallbackData deleteChapterById(@RequestParam("chapterId") Long chapterId) {
        return CallbackData.build(true, () -> {
            chapterService.deleteChapterById(chapterId);
        });
    }

    @PutMapping("/updateChapterById")
    public CallbackData updateChapterById(@RequestBody ChapterInfoDTO chapterInfoDTO) {
        return CallbackData.build(true, () -> {
            chapterService.updateChapterInfoById(chapterInfoDTO);
        });
    }

    @GetMapping("/getChapterListByComicId")
    public CallbackData getChapterListByComicId(@RequestParam("comicId") Long comicId) {
        return CallbackData.build(true, chapterService.listChaptersByComicId(comicId));
    }

}
