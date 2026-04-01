package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private List<AddressBook> addressBookList = new ArrayList<>();
    private Long counter = 1L;

    public AddressBook create(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(counter++, dto.getName(), dto.getCity());
        addressBookList.add(contact);
        return contact;
    }

    public List<AddressBook> getAll() {
        return addressBookList;
    }

    public AddressBook getById(Long id) {
        return addressBookList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Address Book ID not found: " + id));
    }

    public AddressBook update(Long id, AddressBookDTO dto) {
        AddressBook contact = getById(id); // reuse method
        contact.setName(dto.getName());
        contact.setCity(dto.getCity());
        return contact;
    }

    public String delete(Long id) {
        AddressBook contact = getById(id);
        addressBookList.remove(contact);
        return "Deleted successfully";
    }
}