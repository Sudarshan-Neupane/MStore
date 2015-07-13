package mum.edu.mstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(cascade = CascadeType.ALL)
	private List<User> userList = new ArrayList<User>();

	@ManyToOne(cascade = CascadeType.DETACH, fetch= FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	
	private Rate rate;
	
	

	public Rating() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}
	
	public void addUser(User user)
	{
		this.getUserList().add(user);
	}
	

	public enum Rate {
		ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

		private final int ratingValue;

		Rate(int ratingValue) {
			this.ratingValue = ratingValue;
		}

		public int getRatingValue() {
			return this.ratingValue;
		}
	}

	

}