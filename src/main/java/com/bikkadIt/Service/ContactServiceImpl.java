package com.bikkadIt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadIt.Model.Contact;
import com.bikkadIt.Ropository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI {
    
	@Autowired
	private ContactRepository contactRepository;
	
	
	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw('Y');
		Contact save=contactRepository.save(contact);
		if(save !=null && save.getContactId() !=null) {
			return true;
			
		}


	return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> findAll=contactRepository.findAll();
		return findAll;
	}

	@Override
	public Contact getContactById(Integer cid) {
	Optional<Contact>findbyId=contactRepository.findById(cid);
	if(findbyId.isPresent())	{
		
		Contact contact= findbyId.get();
		return contact;
	}
	return null;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
	boolean status	=contactRepository.existsById(cid);
	if(status)	{
	contactRepository.deleteById(cid);
		return true;
	}
	return false;
	}

}
