package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressBookService {

    private Map<Long, AddressBook> data = new HashMap<>();
    private Long counter = 1L;

    public AddressBook create(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(counter++, dto.getName(), dto.getCity());
        data.put(contact.getId(), contact);
        return contact;
    }

    public List<AddressBook> getAll() {
        return new ArrayList<>(data.values());
    }

    public AddressBook getById(Long id) {
        return data.get(id);
    }

    public AddressBook update(Long id, AddressBookDTO dto) {
        AddressBook contact = new AddressBook(id, dto.getName(), dto.getCity());
        data.put(id, contact);
        return contact;
    }

    public String delete(Long id) {
        data.remove(id);
        return "Deleted successfully";
    }
}