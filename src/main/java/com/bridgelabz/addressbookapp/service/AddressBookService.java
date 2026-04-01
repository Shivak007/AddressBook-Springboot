package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
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
        for (AddressBook contact : addressBookList) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }

    public AddressBook update(Long id, AddressBookDTO dto) {
        for (AddressBook contact : addressBookList) {
            if (contact.getId().equals(id)) {
                contact.setName(dto.getName());
                contact.setCity(dto.getCity());
                return contact;
            }
        }
        return null;
    }

    public String delete(Long id) {
        for (int i = 0; i < addressBookList.size(); i++) {
            if (addressBookList.get(i).getId().equals(id)) {
                addressBookList.remove(i);
                return "Deleted successfully";
            }
        }
        return "Contact not found";
    }
}