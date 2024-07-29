package com.ibm.hotel_management_system.admin.dao;

import java.util.List;

import com.ibm.hotel_management_system.dto.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HotelDao {

	EntityManager em = Persistence.createEntityManagerFactory("hotel-project").createEntityManager();

	EntityTransaction et = em.getTransaction();
	
	public Hotel saveHotelDao(Hotel hotel) {
		try {
			et.begin();
			em.persist(hotel);
			et.commit();
			return hotel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 
	 * getAllHotelDetails
	 * 
	 */
	public List<Hotel> getAllHotelDetailsDao(){
		return em.createQuery("FROM Hotel").getResultList();
	}
}
