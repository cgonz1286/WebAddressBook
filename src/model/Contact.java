package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private int contactId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="address_book_id")
	private AddressBook addressBook;
	@OneToMany(mappedBy="contact",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Address> address;
	
	public Contact() {
	}
	
	public Contact(String firstName, String lastName, List<Address> address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Contact(String firstName, String lastName, AddressBook addressBook, List<Address> address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressBook = addressBook;
		this.address = address;
	}

	public Contact(int contactId, String firstName, String lastName, AddressBook addressBook, List<Address> address) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressBook = addressBook;
		this.address = address;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AddressBook getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", addressBook=" + addressBook + ", address=" + address + "]";
	}
	
}
