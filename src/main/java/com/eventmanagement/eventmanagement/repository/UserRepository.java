package com.eventmanagement.eventmanagement.repository;

import java.util.Collection;
import org.springframework.dao.DataAccessException;

import com.eventmanagement.eventmanagement.model.User;

public interface UserRepository {
    
        /**
         * Retrieve <code>User</code> from the database
         * @param lastName Value to search for
         * @return <code>Collection</code> of matching <code>User</code> returning all Users with a given name
         * @throws DataAccessException
         */
        Collection<User> findByLastName(String lastName) throws DataAccessException;
        
        /**
         * Retrieve <code>User</code> from the datastore
         * @param id value to search for
         * @return <code>User</code> that has that id
         * @throws DataAccessException
         */
        User findById(int id) throws DataAccessException;
        
        /**
         * Save <code>User</code> to the database by inserting it or updating it
         * @param user value to save
         * @throws DataAccessException
         */
        void save(User user) throws DataAccessException;
        
        /**
         * Retrieve <code>User</code>s from the database
         * @return <code>Collection</code> of <code>User</code>s
         * @throws DataAccessException
         */
        Collection<User> findAll() throws DataAccessException;
        
        /**
         * Delete a <code>User</code> from the database
         * @param user Value to delete
         * @throws DataAccessException
         */
        void delete(User user) throws DataAccessException;



}
