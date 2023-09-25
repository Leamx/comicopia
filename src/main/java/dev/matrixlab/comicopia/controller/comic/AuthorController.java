package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.entity.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.AuthorService;
import dev.matrixlab.comicopia.utils.CallbackUtils;
import dev.matrixlab.comicopia.vo.comic.AuthorVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/author")
@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(final AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * 创建作者
     * @param authorDTO 必填字段 name
     * @return 创建成功与否
     */
    @PostMapping("/addAuthor")
    public CallbackData<String> addAuthor(@RequestBody AuthorDTO authorDTO) {
        return CallbackUtils.success(authorService.saveAuthor(authorDTO));
    }

    @DeleteMapping("/deleteAuthorById")
    public CallbackData<String> deleteAuthorById(@RequestParam("authorId") Long authorId) {
        return CallbackUtils.success(authorService.removeAuthorById(authorId));
    }

    @PutMapping("/modifyAuthorById")
    public CallbackData<String> modifyAuthorById(@RequestBody AuthorDTO authorDTO) {
        return CallbackUtils.success(authorService.updateAuthorById(authorDTO));
    }

    @GetMapping("/queryAuthorsByName")
    public CallbackData<List<AuthorVO>> queryAuthorsByName(@RequestParam(value = "authorName", required = false, defaultValue = "") String authorName) {
        return CallbackUtils.success(authorService.listAuthorsByName(authorName));
    }

}
