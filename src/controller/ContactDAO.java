package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Contact;

public class ContactDAO {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebAddressBook");
	
	public List<Contact> showAllContacts() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();		
		em.getEntityManagerFactory().getCache().evict(Contact.class);
		
		List<Contact> allContacts = em.createQuery("SELECT contacts FROM Contact contacts").getResultList();
		
		return allContacts;
	}

	public void insertContact(Contact toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(toAdd);
		em.getTransaction().commit();
		
		em.close();
	}

	public String deleteContact(Contact toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		//Write query to retrieve team to delete
		TypedQuery<Contact> typedQuery = em.createQuery("select c from Contact c where c.contactId = :selectedContactId ", Contact.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedContactId", toDelete.getContactId());
		
		
		//We only want one result
		typedQuery.setMaxResults(1);
		
		String message = "";
		
		//Get the result and save it into a new list item
		try {
			Contact result = typedQuery.getSingleResult();
			
			//If exists, Remove it
			em.remove(result);
			em.getTransaction().commit();
			
			message = "Contact was deleted successfully!";
		} 
		catch(NoResultException e) {
			message = "Contact was not deleted, because the entered contact does not exist.";
		}
		
		em.close();
		
		return message;
	}

	public Contact searchForContactById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Contact found = em.find(Contact.class, idToEdit);
		
		em.close();
		
		return found;
	}

	public void updateContact(Contact toEdit) {
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
