package com.bikkadIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bikkadIt.Model.Contact;
import com.bikkadIt.Service.ContactServiceI;

@Controller
public class ContactController {
	
	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping("/saveContact")
	public boolean SaveContact(@RequestBody Contact Contact) {
	boolean cid=contactServiceI.saveContact(Contact);	
	return cid;
	
	}
	
	@GetMapping("/getAllContact")
	List<Contact> getAllContact(){
	List<Contact> list= contactServiceI.getAllContacts();
    return list;
		
	}
	
	@GetMapping("/getContactById/{id}")
    public Contact getContactById(@PathVariable Integer cid) {
    Contact contact=contactServiceI.getContactById(cid);
    return contact;
    
	}
    
    @DeleteMapping("/deleteContactById/{cid}") 
    public boolean deleteContactById(@PathVariable Integer cid){
    boolean contact=contactServiceI.deleteContactById(cid);
    return contact;
    
	}

}
