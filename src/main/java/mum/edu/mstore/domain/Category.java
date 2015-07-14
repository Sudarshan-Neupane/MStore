package mum.edu.mstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Valid
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SubCategory> subCategories;

	public Category() {
		this.subCategories = new ArrayList<SubCategory>();
	}

	public Category(String name) {
		this();
		this.name = name;
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

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public void addSubCategory(SubCategory subCategory) {
		this.subCategories.add(subCategory);
	}

	public void removeSubCategory(SubCategory subCategory) {
		this.subCategories.remove(subCategory);
	}

}
