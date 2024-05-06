package com.eventmanagement.eventmanagement.repository;
import java.util.Collection;
import org.springframework.dao.DataAccessException;
import com.eventmanagement.eventmanagement.model.Review;

public interface ReviewRepository {
    /**
         * Retrieve <code>Review</code>s from the database
         * @param score Value to search for
         * @return <code>Collection</code> of matching <code>Review</code>s returning all Reviews with a given score
         * @throws DataAccessException
         */
        Collection<Review> findByScore(double score) throws DataAccessException;
        
        /**
         * Retrieve <code>Review</code> from the datastore
         * @param id value to search for
         * @return <code>Review</code> that has that id
         * @throws DataAccessException
         */
        Review findById(int id) throws DataAccessException;

        /**
         * Retrieve <code>Review</code>s from the database
         * @param rating Value to search for
         * @return <code>Collection</code> of matching <code>Review</code>s returning all Reviews with a given rating
         * @throws DataAccessException
         */
        Collection<Review> findByRating(boolean rating) throws DataAccessException;
        
        /**
         * Save <code>Review</code> to the database by inserting it or updating it
         * @param Review value to save
         * @throws DataAccessException
         */
        void save(Review Review) throws DataAccessException;
        
        /**
         * Retrieve <code>Review</code>s from the database
         * @return <code>Collection</code> of <code>Review</code>s
         * @throws DataAccessException
         */
        Collection<Review> findAll() throws DataAccessException;
        
        /**
         * Delete a <code>Review</code> from the database
         * @param Review Value to delete
         * @throws DataAccessException
         */
        void delete(Review Review) throws DataAccessException;
}
