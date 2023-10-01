package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.vo.comic.ComicDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ComicVO;

import java.util.List;

public interface ComicService {

    String saveComic(ComicDTO comicDTO);

    String removeComicById(long comicId);

    String updateComicById(ComicDTO comicDTO);

    List<ComicVO> listComicsByName(String comicName);

    ComicDetailsVO getComicDetailsById(long comicId);

    List<ComicVO> listComicsByAuthorName(String authorName);

    List<ComicVO> listComicsByCategoryName(String categoryName);
}
