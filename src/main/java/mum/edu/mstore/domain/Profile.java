package mum.edu.mstore.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author sudarshan user profile
 *
 */
@Entity(name = "profile")
public class Profile {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@NotEmpty
	private String phone;
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "ship_address")),
			@AttributeOverride(name = "city", column = @Column(name = "ship_city")),
			@AttributeOverride(name = "state", column = @Column(name = "ship_state")),
			@AttributeOverride(name = "country", column = @Column(name = "ship_country")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "ship_zipcode"))
			})
	private Address shipping;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "perm_address")),
			@AttributeOverride(name = "city", column = @Column(name = "perm_city")),
			@AttributeOverride(name = "state", column = @Column(name = "perm_state")),
			@AttributeOverride(name = "country", column = @Column(name = "perm_country")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "perm_zipcode"))
			})
	private Address permanentAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getShipping() {
        return shipping;
    }

    public void setShipping(Address shipping) {
        this.shipping = shipping;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }
	
	public enum Gender {
		MALE, FEMALE, OTHERS
	}

}
