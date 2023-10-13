package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.vo.comic.ComicDetailsVO;
import dev.matrixlab.comicopia.vo.comic.ComicVO;

import java.util.List;

public interface ComicService {

    /**
     * 创建漫画
     * @param comicDTO 漫画属性
     * @return 创建成功失败
     */
    String saveComic(ComicDTO comicDTO);

    /**
     * 根据漫画 id 删除漫画
     * @param comicId 漫画 id
     * @return 删除成功或者失败
     */
    String removeComicById(long comicId);

    String updateComicById(ComicDTO comicDTO);

    /**
     *
     * @param comicName
     * @return
     */
    List<ComicVO> listComicsByName(String comicName);

    List<ComicVO> listComicsByAuthorName(String authorName);

    List<ComicVO> listComicsByCategoryName(String categoryName);

    ComicDetailsVO getComicDetailsById(long comicId);
}
