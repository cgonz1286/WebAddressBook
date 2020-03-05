package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zip")
	private String zip;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="contact_id")
	private Contact contact;
	
	public Address() {
		super();
	}
	
	public Address(String city, String state, String zip, Contact contact) {
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.contact = contact;
	}
	
	public Address(String city, String state, String zip) {
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Address(int addressId, String city, String state, String zip, Contact contact) {
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.contact = contact;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", zip=" + zip + ", contact="
				+ contact + "]";
	}
}
