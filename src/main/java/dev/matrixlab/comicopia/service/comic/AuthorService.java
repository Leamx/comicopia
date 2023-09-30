package dev.matrixlab.comicopia.service.comic;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.vo.comic.AuthorVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AuthorService {

    String saveAuthor(AuthorDTO authorDTO);

    String removeAuthorById(long authorId);

    String updateAuthorById(AuthorDTO authorDTO);

    List<AuthorVO> listAuthorsByName(String authorName);

    String updateAvatarById(long authorId, MultipartFile file);

}
