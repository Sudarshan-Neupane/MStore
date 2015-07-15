package mum.edu.mstore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cat_id", nullable = false, updatable = true)
    private Category category;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sub_cat_id", nullable = false, updatable = true)
    private SubCategory subCategory;
    private String artist;
    @Transient
    private MultipartFile image;

    public Album() {
    }

    public Album(String name, Category category, SubCategory subCategory, String artist) {
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
