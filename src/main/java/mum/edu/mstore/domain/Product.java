package mum.edu.mstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_Id")
	private Category category;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subcategory_Id")
	private SubCategory subCategory;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "album_Id")
	private Album album;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "product_Id")
	List<ProductFile> productFile = new ArrayList<ProductFile>();
	

	private long year;

	private double price;

	private String length;

	@Column(name = "Image")
	private String musicImage;


	public Product() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<ProductFile> getProductFile() {
		return productFile;
	}

	public void setProductFile(List<ProductFile> productFile) {
		this.productFile = productFile;
	}
	
	public void addProductFile(ProductFile productFile)
	{
		this.getProductFile().add(productFile);
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	
	

    public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}


	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMusicImage() {
		return musicImage;
	}

	public void setMusicImage(String musicImage) {
		this.musicImage = musicImage;
	}


}
