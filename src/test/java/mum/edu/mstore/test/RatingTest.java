package mum.edu.mstore.test;

import java.util.List;

import mum.edu.mstore.domain.Album;
import mum.edu.mstore.domain.Category;
import mum.edu.mstore.domain.Product;
import mum.edu.mstore.domain.ProductFile;
import mum.edu.mstore.domain.Profile;
import mum.edu.mstore.domain.Profile.Gender;
import mum.edu.mstore.domain.Rating;
import mum.edu.mstore.domain.Rating.Rate;
import mum.edu.mstore.domain.SubCategory;
import mum.edu.mstore.domain.User;
import mum.edu.mstore.service.ProductService;
import mum.edu.mstore.service.RatingService;
import mum.edu.mstore.service.UserService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RatingTest extends BaseTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private RatingService ratingService;
	@Autowired
	private UserService userService;

	private static final String PROD_NAME = "timro nyano";
	private static final String CAT_NAME = "Solo Music";
	private static final String SUB_CAT_NAME_1 = "Fast Track";
	private static final String Artist = "Nuhendra";
	private static final long year = 2001;
	private static final double Price = 14.0;
	private static final String duration = "4:09";
	private static final String musicImage = "PAth";
	private static final String USER_NAME = "nuhendra";
	private static final String ALBUM_NAME = "album";

	@Test
	public void addTest() {

		Rating rating = new Rating();
		System.out.println("findProductByName: " + PROD_NAME);
		Product product = this.productService.findByProductName(PROD_NAME);

		// Category category = new Category();
		// SubCategory subCategory = new SubCategory();
		// ProductFile productFile = new ProductFile();
		// Album album = new Album();
		// Profile profile = new Profile();
		// profile.setGender(Gender.MALE);
		// profile.setPhone("123456");

		System.out.println("findByUserName: admin@mstore.com");
		User user = this.userService.findByUserName("admin@mstore.com");
		// user.setEnabled(true);
		// user.setFirstName("admin");
		// user.setLastName("admin");
		// user.setMiddleName("admin");
		// user.setPassword("123456");
		// user.setUserName("admin@mstore.com");
		// user.setProfile(profile);

		// album.setCategory(category);
		// album.setName(ALBUM_NAME);
		// album.setCategory(category);
		// album.setSubCategory(subCategory);
		//
		//
		// productFile.setFilePath(musicImage);
		// productFile.setFileType(FileType.MP3);
		// subCategory.setName(SUB_CAT_NAME_1);
		// category.setName(CAT_NAME);
		// category.addSubCategory(subCategory);
		// product.setName(PROD_NAME);
		// product.setCategory(category);
		// product.setSubCategory(subCategory);
		// product.addProductFile(productFile);
		// product.setArtistName(Artist);
		// product.setYear(year);
		// product.setPrice(Price);
		// product.setType(Type.MP3);
		// product.setMusicImage(musicImage);
		// product.setAlbum(album);
		//
		// this.productService.add(product);

		rating.setProduct(product);
		rating.setRate(Rate.ONE);
		rating.addUser(user);
		System.out.println("add rating for the product");
		this.ratingService.add(rating);

		List<Rating> myList = this.ratingService.findByProduct(product);

		Assert.assertEquals(myList.get(0).getRate(), Rate.ONE);

	}

}
