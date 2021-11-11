package com.bikkadIt.Service;

import java.util.List;

import com.bikkadIt.Model.Contact;



public interface ContactServiceI {
	
	boolean saveContact(Contact contact);


	List<Contact> getAllContacts( );


	Contact getContactById(Integer cid);


	boolean deleteContactById(Integer cid);

}
