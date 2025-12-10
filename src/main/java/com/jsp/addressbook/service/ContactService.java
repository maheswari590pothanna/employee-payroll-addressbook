package com.jsp.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.addressbook.entity.Contact;

@Service
public class ContactService {
	private final List<Contact> contacts = new ArrayList<>();

	public List<Contact> getAll() {
		return contacts;
	}

	public Contact getById(int id) {
		return contacts.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
	}

	public Contact add(Contact c) {
		contacts.add(c);
		return c;
	}

	public Contact update(int id, Contact newC) {
		Contact old = getById(id);
		if (old != null) {
			old.setName(newC.getName());
			old.setPhone(newC.getPhone());
			old.setEmail(newC.getEmail());
		}
		return old;
	}

	public boolean delete(int id) {
		return contacts.removeIf(c -> c.getId() == id);
	}

}
