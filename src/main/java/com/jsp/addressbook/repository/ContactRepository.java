package com.jsp.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.addressbook.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
