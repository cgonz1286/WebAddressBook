import controller.AddressDAO;
import controller.ContactDAO;
import model.Address;
import model.AddressBook;
import model.Contact;

import java.util.List;

import controller.AddressBookDAO;;

public class WebAddressBookTester {
	
	public static void main(String[] args) {
		
		AddressDAO addressDAO = new AddressDAO();
		
  		Address newAddress = new Address("Ankeny", "Iowa", "50023");

  		addressDAO.insertAddress(newAddress);
		
  		List<Address> allAddresses = addressDAO.showAllAddresses();
  		for (Address a : allAddresses) {
  			System.out.println(a.toString());
  		}
		
		Address existingAddress = addressDAO.searchForAddressById(1);
		existingAddress.setCity("Altoona");
		existingAddress.setState("IA");
		existingAddress.setZip("50107");
		
		addressDAO.updateAddress(existingAddress);
//		addressDAO.deletePlayer(existingAddress);	
		
  		allAddresses = addressDAO.showAllAddresses();
  		for (Address a : allAddresses) {
  			System.out.println(a.toString());
  		}
  		
//  	------------------------------------------------------
  		
//		ContactDAO contactDAO = new ContactDAO();
//		
//  		Contact newContact = new Contact("Chris", "Gonzalez", newAddress);
//  		Contact newContact2 = new Contact("Ben", "Gonzalez", newAddress);
//
//    	contactDAO.insertContact(newContact);
//		
//  		List<Contact> allContacts = contactDAO.showAllContacts();
//  		for (Contact c : allContacts) {
//  			System.out.println(c.toString());
//  		}
//		
//		Contact existingContact = contactDAO.searchForContactById(1);
//		existingContact.setFirstName("Christopher");
//		existingContact.setLastName("Gonzalez");
//		existingContact.setAddress(newAddress);
//		
//		contactDAO.updateContact(existingContact);
//  		contactDAO.deletePlayer(existingAddress);	
//		
//  		allContacts = contactDAO.showAllContacts();
//  		for (Contact c : allContacts) {
//  			System.out.println(c.toString());
//  		}
//  		
//    	------------------------------------------------------
//  		
//		AddressBookDAO addressBookDAO = new AddressBookDAO();
//		
//  		AddressBook newAddressBook = new AddressBook("Ankeny", "Iowa", "50023");
//
//  		addressBookDAO.insertAddressBook(newAddressBook);
//		
//  		List<AddressBook> allAddressBooks = addressBookDAO.showAllAddressBooks();
//  		for (AddressBook ab : allAddressBooks) {
//  			System.out.println(ab.toString());
//  		}
//		
//		AddressBook existingAddressBooks = addressBookDAO.searchForAddressBookById(1);
//		existingAddressBooks.setName("Friends");
//  		existingAddressBooks.setDateAdded();
//  		existingAddressBooks.setContact();
//		
//  		addressDAO.updateAddressBook(existingAddress);
//  		addressDAO.deleteAddressBook(existingAddress);	
//		
//  		allAddresses = addressDAO.showAllAddresses();
//  		for (Address a : allAddresses) {
//  			System.out.println(a.toString());
//  		}

	}
	
}
