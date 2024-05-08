package com.eventmanagement.eventmanagement.repository.Impl;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.eventmanagement.eventmanagement.model.Event;
import com.eventmanagement.eventmanagement.model.Registration;
import com.eventmanagement.eventmanagement.model.User;
import com.eventmanagement.eventmanagement.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertUser;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        this.insertUser = new SimpleJdbcInsert(dataSource)
            .withTableName("User")
            .usingGeneratedKeyColumns("user_id");

            this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    @Override
    public Collection<User> findByLastName(String lastName) throws DataAccessException {
        Map<String, Object> params = new HashMap<>();
        params.put("lastName", lastName + "%");
        List<User> users = this.jdbc.query (
            "SELECT user_id, first_name, last_name, email, bio, age FROM User WHERE last_name like :lastName",
            params, BeanPropertyRowMapper.newInstance(User.class)

        );
        return users;
    }

    public List<Registration> findRegistrationsByUserId(Integer userId) throws DataAccessException {
            Map<String, Object> params = new HashMap<>();
            params.put("userId", userId);

            List<Registration> registrations = this.jdbc.query(
                "SELECT r.registration_id, r.registration_date, e.title, e.location, e.start_date," + 
                "u.first_name, u.last_name" + 
                "FROM Registration r " + 
                "JOIN Event e ON r.event_id = e.event_id " + 
                "JOIN User u ON r.user_id = u.user_id" +
                "WHERE r.user_id = :userId"
                , params, 
                
                (ResultSet rs, int rowNum) -> {
                    Registration registration = new Registration();
                    registration.setRegistration_id(rs.getInt("registration_id"));
                    registration.setRegistrationDate(rs.getTimestamp("registration_date").toLocalDateTime());

                    User user = new User();
                    user.setUser_id(userId);
                    registration.setUser(user);
                    Event event = new Event();
                    event.setEvent_id(rs.getInt("event_id"));
                    registration.setEvent(event);

                    return registration;
                }
                );

                return registrations;
    } 

    @Override
    public User findById(int id) throws DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void save(User user) throws DataAccessException {
        if(getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw new IllegalArgumentException("Email already in use");
    }

    @Override
    public Collection<User> findAll() throws DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void delete(User user) throws DataAccessException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    public Integer getEmailCount(String email) {
        String COUNT_USER_EMAIL_QUERY = "SELECT COUNT(*) FROM User WHERE email = :email";
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }
}
