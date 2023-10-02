package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.ChapterDTO;
import dev.matrixlab.comicopia.entity.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.ChapterService;
import dev.matrixlab.comicopia.utils.CallbackUtils;
import dev.matrixlab.comicopia.vo.comic.ChapterDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ChapterVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(final ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @PostMapping("/addChapter")
    public CallbackData<String> addChapter(@RequestBody ChapterDTO chapterDTO) {
        return CallbackUtils.success(chapterService.saveChapter(chapterDTO));
    }

    @DeleteMapping("/deleteChapterById")
    public CallbackData<String> deleteChapterById(@RequestParam("chapterId") long chapterId) {
        return CallbackUtils.success(chapterService.removeChapterById(chapterId));
    }

    @PutMapping("/modifyChapterById")
    public CallbackData<String> modifyChapterById(@RequestBody ChapterDTO chapterDTO) {
        return CallbackUtils.success(chapterService.updateChapterById(chapterDTO));
    }

    @GetMapping("/queryChaptersByComicId")
    public CallbackData<List<ChapterVO>> queryChaptersByComicId(@RequestParam("comicId") long comicId) {
        return CallbackUtils.success(chapterService.listChaptersByComicId(comicId));
    }

    @GetMapping("/queryChapterDetailsById")
    public CallbackData<ChapterDetailsVO> queryChapterDetailsById(@RequestParam("chapterId") long chapterId) {
        return CallbackUtils.success(chapterService.getChapterDetailsById(chapterId));
    }

    @PostMapping("/addChapterImagesById")
    public CallbackData<String> addChapterImagesById(@RequestParam("chapterId") long chapterId, @RequestParam("files") List<MultipartFile> files) {
        return CallbackUtils.success(chapterService.saveChapterImagesById(chapterId, files));
    }

}
