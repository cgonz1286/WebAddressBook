package model;

import java.time.LocalDate;

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
@Table(name = "address_book")
public class AddressBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "date_added")
	private LocalDate dateAdded;
	@ManyToOne(cascade=CascadeType.PERSIST)//not sure if we will need to change this 
	@JoinColumn(name="contact_id")
	private Contact contact;
	
	public AddressBook() {
	}
	
	public AddressBook(String name, LocalDate dateAdded, Contact contact) {
		this.name = name;
		this.dateAdded = dateAdded;
		this.contact = contact;
	}
	
	public AddressBook(int id, String name, LocalDate dateAdded, Contact contact) {
		this.id = id;
		this.name = name;
		this.dateAdded = dateAdded;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getname() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	
	
}
