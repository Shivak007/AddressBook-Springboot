package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private Map<Long, AddressBook> data = new HashMap<>();
    private Long counter = 1L;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAll() {
        return ResponseEntity.ok(new ArrayList<>(data.values()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getById(@PathVariable Long id) {
        return ResponseEntity.ok(data.get(id));
    }

    @PostMapping
    public ResponseEntity<AddressBook> create(@RequestBody AddressBook contact) {
        contact.setId(counter++);
        data.put(contact.getId(), contact);
        return ResponseEntity.ok(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> update(@PathVariable Long id,
                                              @RequestBody AddressBook contact) {
        contact.setId(id);
        data.put(id, contact);
        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        data.remove(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}