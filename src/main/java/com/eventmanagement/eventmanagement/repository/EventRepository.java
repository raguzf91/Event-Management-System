package com.eventmanagement.eventmanagement.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.eventmanagement.eventmanagement.model.Event;


public interface EventRepository {
    

     /**
         * Retrieve <code>Event</code> from the database
         * @param title Value to search for
         * @return <code>Collection</code> of matching <code>Event</code> returning all Events with a given title
         * @throws DataAccessException
         */
        Collection<Event> findByTitle(String title) throws DataAccessException;

         /**
         * Retrieve <code>Event</code> from the database
         * @param location Value to search for
         * @return <code>Collection</code> of matching <code>Event</code> returning all Events with a given location
         * @throws DataAccessException
         */
        Collection<Event> findByLocation(String location) throws DataAccessException;

         /**
         * Retrieve <code>Event</code> from the database
         * @param startDate Value to search for
         * @return <code>Collection</code> of matching <code>Event</code> returning all Events with a given startDate
         * @throws DataAccessException
         */
        Collection<Event> findBystartDate(LocalDateTime startDate) throws DataAccessException;

         /**
         * Retrieve <code>Event</code> from the database
         * @param endDate Value to search for
         * @return <code>Collection</code> of matching <code>Event</code> returning all Events with a given endDate
         * @throws DataAccessException
         */
        Collection<Event> findByendDate(LocalDateTime endDate) throws DataAccessException;
        
        /**
         * Retrieve <code>Event</code> from the datastore
         * @param id value to search for
         * @return <code>Event</code> that has that id
         * @throws DataAccessException
         */
        Event findById(int id) throws DataAccessException;
        
        /**
         * Save <code>Event</code> to the database by inserting it or updating it
         * @param Event value to save
         * @throws DataAccessException
         */
        void save(Event Event) throws DataAccessException;
        
        /**
         * Retrieve <code>Event</code>s from the database
         * @return <code>Collection</code> of <code>Event</code>s
         * @throws DataAccessException
         */
        Collection<Event> findAll() throws DataAccessException;
        
        /**
         * Delete a <code>Event</code> from the database
         * @param Event Value to delete
         * @throws DataAccessException
         */
        void delete(Event Event) throws DataAccessException;
}
