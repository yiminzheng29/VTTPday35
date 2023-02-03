package sg.edu.nus.pafworkshop21.workshop21.controllers;

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

import sg.edu.nus.pafworkshop21.workshop21.models.Contact;
import sg.edu.nus.pafworkshop21.workshop21.repositories.ContactRepository;



@Controller
@RequestMapping(path="/contact", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class ContactController {

    @Autowired
    private ContactRepository contactRepo;
    
    @PostMapping(consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    ResponseEntity<String> postContactEntity(@RequestBody MultiValueMap<String,String> form) {
        System.out.println(">>> Contact form: " + form);

        Contact newContact = Contact.create(form);
        System.out.println(">>> Contact: " + newContact);

        // after contact is created, it is inserted into repo
        contactRepo.insertContact(newContact);

        return ResponseEntity.ok(newContact.toJson().toString());
    }
}
