package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AddressBook;

public class AddressBookDAO {

static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebAddressBook");
	
	public List<AddressBook> showAllAddressBooks() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();		
		em.getEntityManagerFactory().getCache().evict(AddressBook.class);
		
		List<AddressBook> allAddressBooks = em.createQuery("SELECT addressBooks FROM AddressBook addressBooks").getResultList();
		
		return allAddressBooks;
	}

	public void insertAddressBook(AddressBook toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(toAdd);
		em.getTransaction().commit();
		
		em.close();
	}

	public String deleteAddressBook(AddressBook toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		//Write query to retrieve team to delete
		TypedQuery<AddressBook> typedQuery = em.createQuery("select ab from AddressBook ab where ab.id = :selectedId and ab.name = :selectedName " + 
														    "and ab.dateAdded = :selectedDateAdded and ab.contact = :selectedContact", AddressBook.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedDateAdded", toDelete.getDateAdded());
		typedQuery.setParameter("selectedContact", toDelete.getContacts());
		
		//We only want one result
		typedQuery.setMaxResults(1);
		
		String message = "";
		
		//Get the result and save it into a new list item
		try {
			AddressBook result = typedQuery.getSingleResult();
			
			//If exists, Remove it
			em.remove(result);
			em.getTransaction().commit();
			
			message = "AddressBook was deleted successfully!";
		} 
		catch(NoResultException e) {
			message = "AddressBook was not deleted, because the entered AddressBook does not exist.";
		}
		
		em.close();
		
		return message;
	}

	public AddressBook searchForAddressBookById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		AddressBook found = em.find(AddressBook.class, idToEdit);
		
		em.close();
		
		return found;
	}

	public void updateAddressBook(AddressBook toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		
		em.close();
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}
	
}
