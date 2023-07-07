package dev.matrixlab.comicopia.controller.comic;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.dto.system.CallbackData;
import dev.matrixlab.comicopia.service.comic.AuthorService;
import dev.matrixlab.comicopia.service.comic.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/author")
@RequiredArgsConstructor
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/createAuthor")
    private CallbackData createAuthor(@RequestBody AuthorDTO authorDTO) {
        return CallbackData.build(true, () -> {
            authorService.createAuthor(authorDTO);
        });
    }

    @DeleteMapping("/deleteAuthorById")
    private CallbackData deleteAuthorById(@RequestParam("authorId") Long authorId) {
        return CallbackData.build(true, () -> {
            authorService.deleteAuthorById(authorId);
        });
    }

    @PutMapping("/updateAuthorById")
    private CallbackData updateAuthorById(@RequestBody AuthorDTO authorDTO) {
        return CallbackData.build(true, () -> {
            authorService.updateAuthorById(authorDTO);
        });
    }

    @GetMapping("/getAuthorListByName")
    private CallbackData getAuthorListByName(@RequestParam("authorName") String authorName) {
        return CallbackData.build(true, authorService.getAuthorListByName(authorName));
    }

}
