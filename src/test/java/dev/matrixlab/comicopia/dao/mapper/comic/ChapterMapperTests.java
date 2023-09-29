package dev.matrixlab.comicopia.dao.mapper.comic;

import dev.matrixlab.comicopia.vo.comic.ChapterDetailsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChapterMapperTests {

    @Autowired
    private ChapterMapper chapterMapper;

    @Test
    public void testSelectChapterDetailsById() {
        ChapterDetailsVO chapterDetailsVO = chapterMapper.selectChapterDetailsById(3L);
        System.out.println(chapterDetailsVO);
    }

}
