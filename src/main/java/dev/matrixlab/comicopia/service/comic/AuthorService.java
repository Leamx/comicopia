package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.vo.comic.AuthorVO;

import java.util.List;

public interface AuthorService {

    String saveAuthor(AuthorDTO authorDTO);

    String removeAuthorById(Long authorId);

    String updateAuthorById(AuthorDTO authorDTO);

    List<AuthorVO> listAuthorsByName(String authorName);

}
