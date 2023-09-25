package dev.matrixlab.comicopia.dto.mapper;

import dev.matrixlab.comicopia.dto.comic.AuthorDTO;
import dev.matrixlab.comicopia.dto.comic.CategoryDTO;
import dev.matrixlab.comicopia.dto.comic.ChapterInfoDTO;
import dev.matrixlab.comicopia.dto.comic.ComicDTO;
import dev.matrixlab.comicopia.entity.comic.AuthorDO;
import dev.matrixlab.comicopia.entity.comic.CategoryDO;
import dev.matrixlab.comicopia.entity.comic.ChapterDO;
import dev.matrixlab.comicopia.entity.comic.ComicDO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BeanMapperStruct {

    BeanMapperStruct BEAN_MAPPER_STRUCT = Mappers.getMapper(BeanMapperStruct.class);

    // -------------------------- comic -------------------------------------

    ComicDO comicDTO2ComicDO(ComicDTO comicDTO);

    ComicDTO comicDO2ComicDTO(ComicDO comicDO);

    // -------------------------- author -------------------------------------

    AuthorDO authorDTO2AuthorDO(AuthorDTO authorDTO);

    // -------------------------- category -------------------------------------

    CategoryDO categoryDTO2CategoryDO(CategoryDTO categoryDTO);

    // -------------------------- chapter -------------------------------------

    ChapterDO chatperInfoDTO2ChapterDO(ChapterInfoDTO chapterInfoDTO);

}
