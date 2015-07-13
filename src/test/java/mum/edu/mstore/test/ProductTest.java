package mum.edu.mstore.test;

import mum.edu.mstore.domain.Album;
import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.Product;
import mum.edu.mstore.domain.Product.Type;
import mum.edu.mstore.domain.ProductFile;
import mum.edu.mstore.domain.ProductFile.FileType;
import mum.edu.mstore.domain.SubCategory;
import mum.edu.mstore.service.ProductService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductTest extends BaseTest {
	
	@Autowired
	private ProductService productService;
	
	private static final String PROD_NAME = "timro nyano";
	private static final String CAT_NAME = "Solo Music";
	private static final String SUB_CAT_NAME_1 = "Fast Track";
	private static final String Artist = "Nuhendra";
	private static final long year = 2001;
	private static final double Price = 14.0;
	private static final String duration = "4:09";
	private static final String musicImage = "PAth";
	private static final String ALBUM_NAME = "album";
	
	
	@Test
	public void addTest()
	{
		Product product = new Product();
		Category category = new Category();
		SubCategory subCategory = new SubCategory();
		ProductFile productFile = new ProductFile();
		Album album = new Album();
		
		album.setCategory(category);
		album.setName(ALBUM_NAME);
		album.setCategory(category);
		album.setSubCategory(subCategory);
		
		
		productFile.setFilePath(musicImage);
		productFile.setFileType(FileType.MP3);
		subCategory.setName(SUB_CAT_NAME_1);
		category.setName(CAT_NAME);
		category.addSubCategory(subCategory);
		product.setName(PROD_NAME);
		product.setCategory(category);
		product.setSubCategory(subCategory);
		product.addProductFile(productFile);
		product.setArtistName(Artist);
		product.setYear(year);
		product.setPrice(Price);
		product.setType(Type.MP3);
		product.setMusicImage(musicImage);
		product.setAlbum(album);
		
	  this.productService.add(product);
	  Product p = this.productService.findByProductName(PROD_NAME);
	  System.out.println(p.getName());
		Assert.assertEquals(p.getName(),"timro nyano");
		
	}
}
