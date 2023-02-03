package sg.edu.nus.iss.app.workshop26.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.app.workshop26.models.Contact;
import sg.edu.nus.iss.app.workshop26.repositories.ContactRepository;

@Controller
@RequestMapping(path="/contact", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactRepository contactRepo;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    ResponseEntity<String> postContacEntity(@RequestBody MultiValueMap<String, String> form) {

        System.out.println(">>> contact form: " + form);

        Contact newContact = Contact.create(form);
        System.out.println(">>> contact: " + newContact);

        // insert into mongo
        contactRepo.insertContact(newContact);
        
        return ResponseEntity.ok(newContact.toJson().toString());
    }
    
}