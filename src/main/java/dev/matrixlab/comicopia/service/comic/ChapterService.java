package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.ChapterDTO;
import dev.matrixlab.comicopia.vo.comic.ChapterDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ChapterVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChapterService {

    String saveChapter(ChapterDTO chapterDTO);

    String removeChapterById(long chapterId);

    String updateChapterById(ChapterDTO chapterDTO);

    List<ChapterVO> listChaptersByComicId(long comicId);

    ChapterDetailsVO getChapterDetailsById(long chapterId);

    /**
     * 根据章节id保存章节图片
     * @param chapterId 章节 id
     * @param files 图片文件
     * @return 保存结果
     */
    String saveChapterImagesById(long chapterId, List<MultipartFile> files);
}
