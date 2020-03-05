package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(
		cascade=CascadeType.MERGE,
		orphanRemoval = true
	)
	@JoinColumn(name = "address_book_id")
	private List<Contact> contacts;
	
	public AddressBook() {
	}
	
	public AddressBook(String name) {
		this.name = name;
	}
	
	public AddressBook(String name, LocalDate dateAdded) {
		this.name = name;
		this.dateAdded = dateAdded;
	}
	
	public AddressBook(String name, List<Contact> contacts) {
		this.name = name;
		this.contacts = contacts;
	}

	public AddressBook(String name, LocalDate dateAdded, List<Contact> contacts) {
		this.name = name;
		this.dateAdded = dateAdded;
		this.contacts = contacts;
	}

	public AddressBook(int id, String name, LocalDate dateAdded, List<Contact> contacts) {
		this.id = id;
		this.name = name;
		this.dateAdded = dateAdded;
		this.contacts = contacts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
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

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", name=" + name + ", dateAdded=" + dateAdded + ", contacts=" + contacts + "]";
	}
}
