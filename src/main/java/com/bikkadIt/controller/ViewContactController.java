package com.bikkadIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bikkadIt.Model.Contact;
import com.bikkadIt.Service.ContactServiceI;


@Controller
public class ViewContactController {
	
	@Autowired
	private ContactServiceI contactServiceI;
	
	@GetMapping("/edit")
    public String editContact(@PathVariable("cid") Integer contactId,Model model) {
    Contact contact=contactServiceI.getContactById(contactId);
    model.addAttribute("contact",contact);
    return "contactInfo";
    
	}
    
    @DeleteMapping("/delete") 
    public String deleteContact (@PathVariable("cid") Integer contactId,Model model){
    boolean contact=contactServiceI.deleteContactById(contactId);
    return "redirect:viewContacts";
    
	}

}
