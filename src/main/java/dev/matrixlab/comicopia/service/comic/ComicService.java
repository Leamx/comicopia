package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.ComicDTO;

import java.util.List;

public interface ComicService {

    void createComic(ComicDTO comicDTO);

    void deleteComicById(Long comicId);

    void updateComicById(ComicDTO comicDTO);

    List<ComicDTO> listComicsByName(String comicName);

}
