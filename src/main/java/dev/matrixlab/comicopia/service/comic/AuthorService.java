package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;

import java.util.List;

public interface AuthorService {

    void createAuthor(AuthorDTO authorDTO);

    void deleteAuthorById(Long authorId);

    void updateAuthorById(AuthorDTO authorDTO);

    List<AuthorDTO> getAuthorListByName(String authorName);

}
