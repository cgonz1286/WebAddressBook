package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;

public class AddressDAO {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebAddressBook");
	
	public List<Address> showAllAddresses() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();		
		em.getEntityManagerFactory().getCache().evict(Address.class);
		
		List<Address> allAddresses = em.createQuery("SELECT addresses FROM Address addresses").getResultList();
		
		return allAddresses;
	}

	public void insertAddress(Address toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(toAdd);
		em.getTransaction().commit();
		
		em.close();
	}

	public String deleteAddress(Address toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		//Write query to retrieve team to delete
		TypedQuery<Address> typedQuery = em.createQuery("select a from Address a where a.addressId = :selectedAddressId and a.city = :selectedCity " + 
														"and a.state = :selectedState and a.zip = :selectedZip", Address.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedAddressId", toDelete.getAddressId());
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedState", toDelete.getState());
		typedQuery.setParameter("selectedZip", toDelete.getZip());
		
		//We only want one result
		typedQuery.setMaxResults(1);
		
		String message = "";
		
		//Get the result and save it into a new list item
		try {
			Address result = typedQuery.getSingleResult();
			
			//If exists, Remove it
			em.remove(result);
			em.getTransaction().commit();
			
			message = "Address was deleted successfully!";
		} 
		catch(NoResultException e) {
			message = "Address was not deleted, because the entered address does not exist.";
		}
		
		em.close();
		
		return message;
	}

	public Address searchForAddressById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Address found = em.find(Address.class, idToEdit);
		
		em.close();
		
		return found;
	}

	public void updateAddress(Address toEdit) {
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
