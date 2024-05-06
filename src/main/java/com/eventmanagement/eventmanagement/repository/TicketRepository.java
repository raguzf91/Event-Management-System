package com.eventmanagement.eventmanagement.repository;
import java.util.Collection;
import org.springframework.dao.DataAccessException;

import com.eventmanagement.eventmanagement.enums.TicketType;
import com.eventmanagement.eventmanagement.model.Ticket;

public interface TicketRepository {
    /**
         * Retrieve <code>Ticket</code> from the database
         * @param id Value to search for
         * @return <code>Collection</code> of matching <code>Ticket</code> returning the Ticket with a given id
         * @throws DataAccessException
         */
        Ticket findById(int id) throws DataAccessException;
        
        /**
         * Retrieve <code>Ticket</code>s from the database
         * @param type value to search for
         * @return <code>Ticket</code> that has that type
         * @throws DataAccessException
         */
        Collection<Ticket> findByType(TicketType type) throws DataAccessException;
        
        /**
         * Save <code>Ticket</code> to the database by inserting it or updating it
         * @param Ticket value to save
         * @throws DataAccessException
         */
        void save(Ticket Ticket) throws DataAccessException;
        
        /**
         * Retrieve <code>Ticket</code>s from the database
         * @return <code>Collection</code> of <code>Ticket</code>s
         * @throws DataAccessException
         */
        Collection<Ticket> findAll() throws DataAccessException;
        
        /**
         * Delete a <code>Ticket</code> from the database
         * @param Ticket Value to delete
         * @throws DataAccessException
         */
        void delete(Ticket Ticket) throws DataAccessException;
}
