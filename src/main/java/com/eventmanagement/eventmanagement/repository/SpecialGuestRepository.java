package com.eventmanagement.eventmanagement.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.eventmanagement.eventmanagement.model.SpecialGuest;

public interface SpecialGuestRepository {
    /**
         * Retrieve <code>SpecialGuest</code> from the database
         * @param lastName Value to search for
         * @return <code>Collection</code> of matching <code>SpecialGuest</code> returning all SpecialGuests with a given name
         * @throws DataAccessException
         */
        Collection<SpecialGuest> findByLastName(String lastName) throws DataAccessException;
        
        /**
         * Retrieve <code>SpecialGuest</code> from the datastore
         * @param id value to search for
         * @return <code>SpecialGuest</code> that has that id
         * @throws DataAccessException
         */
        SpecialGuest findById(int id) throws DataAccessException;
        
        /**
         * Save <code>SpecialGuest</code> to the database by inserting it or updating it
         * @param SpecialGuest value to save
         * @throws DataAccessException
         */
        void save(SpecialGuest SpecialGuest) throws DataAccessException;
        
        /**
         * Retrieve <code>SpecialGuest</code>s from the database
         * @return <code>Collection</code> of <code>SpecialGuest</code>s
         * @throws DataAccessException
         */
        Collection<SpecialGuest> findAll() throws DataAccessException;
        
        /**
         * Delete a <code>SpecialGuest</code> from the database
         * @param SpecialGuest Value to delete
         * @throws DataAccessException
         */
        void delete(SpecialGuest SpecialGuest) throws DataAccessException;

}
