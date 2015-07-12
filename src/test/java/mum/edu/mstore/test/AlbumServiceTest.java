package mum.edu.mstore.test;

import mum.edu.mstore.domain.Album;
import mum.edu.mstore.domain.Category;
import mum.edu.mstore.service.AlbumService;
import mum.edu.mstore.service.CategoryService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(Suite.class)
//@SuiteClasses({CategoryServiceTest.class})
public class AlbumServiceTest extends BaseTest {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private CategoryService categoryService;
    private static final String NAME = "Old City";
    private static final String CATEGORY_NAME = "Solo Music";
    private static final String ARTIST = "Adele";

    @Test
    public void addAlbumTest() {
        Category cat = categoryService.findByName(CATEGORY_NAME);
        System.out.println("cat name inside album test: " + cat.getName());
        Album album = new Album(NAME, cat, cat.getSubCategories().get(0), ARTIST);
        this.albumService.add(album);
        Album albs = this.albumService.findAll().get(0);
        Assert.assertEquals(NAME, albs.getName());
    }
}
