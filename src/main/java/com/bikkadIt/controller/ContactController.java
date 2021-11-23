package com.bikkadIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/contact")
	private String loadContactForm(Model model) {
		Contact contactobj=new Contact();
		model.addAttribute("contact",contactobj);
		return "contactInfo";	
	}

	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact,Model model) {
        boolean isSaved=contactServiceI.saveContact(contact);
	    if(isSaved) {
        	model.addAttribute("success", "contact saved Successfully");
        }else {
        	model.addAttribute("error", "Failed to save Contact");
        }
         return "contactInfo" ;
	}
	
	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {
	    List<Contact> allContacts=contactServiceI.getAllContacts();
	    model.addAttribute("contacts", allContacts)	;
	    return "contacts";	
	
	}
	
	

}
