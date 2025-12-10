package com.jsp.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.addressbook.entity.Contact;
import com.jsp.addressbook.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	@Autowired
	private ContactService service;

	@GetMapping
	public List<Contact> all() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contact> byId(@PathVariable int id) {
		Contact c = service.getById(id);
		return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(c);
	}

	@PostMapping
	public ResponseEntity<Contact> create(@RequestBody Contact c) {
		if (service.getById(c.getId()) != null) {
			return ResponseEntity.status(409).build();
		}
		return ResponseEntity.ok(service.add(c));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Contact> update(@PathVariable int id, @RequestBody Contact c) {
		Contact updated = service.update(id, c);
		return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		boolean removed = service.delete(id);
		return removed ? ResponseEntity.ok("Deleted") : ResponseEntity.notFound().build();
	}

}
