package com.bikkadIt.Ropository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bikkadIt.Model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
