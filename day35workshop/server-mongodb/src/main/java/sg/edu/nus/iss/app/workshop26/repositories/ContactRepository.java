package sg.edu.nus.iss.app.workshop26.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.workshop26.models.Contact;

@Repository
public class ContactRepository {
    
    @Autowired 
    private MongoTemplate mongoTemplate;

    public void insertContact(Contact contact) {

        
        Document doc = new Document();
        doc.put("name", contact.getName());
        doc.put("phone", contact.getPhone());
        doc.put("email", contact.getEmail());

        System.out.println(contact.getName());
        mongoTemplate.insert(doc, "contacts"); // "contacts" is the collection/db name in mongosh
    }
}
