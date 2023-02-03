package sg.edu.nus.pafworkshop21.workshop21.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.pafworkshop21.workshop21.models.Contact;

import static sg.edu.nus.pafworkshop21.workshop21.repositories.Queries.*;

@Repository
public class ContactRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // inserts data into sql
    public void insertContact(Contact contact) {
        jdbcTemplate.update(SQL_INSERT_CONTACT, contact.getName(), contact.getPhone(), contact.getEmail());
    }
}
